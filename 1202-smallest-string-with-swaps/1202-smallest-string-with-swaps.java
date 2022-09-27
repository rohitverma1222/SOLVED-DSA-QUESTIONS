class Solution {
    int []rank;
    int []parent;
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        parent=new int[s.length()+1];
        rank=new int[s.length()+1];

        for(int i=0;i<s.length();i++)
        {
            parent[i]=i;
            rank[i]=0;
        }

        for(List<Integer> li:pairs)
        {
            union(li.get(0),li.get(1));
        }

        HashMap<Integer,PriorityQueue<Character>> hs=new HashMap<>();

        for(int i=0;i<s.length();i++)
        {
            int lead=find(i);
            char ch=s.charAt(i);

            if(hs.containsKey(lead)==false)
            {
                PriorityQueue<Character> pq=new PriorityQueue<>();
                pq.add(ch);
                hs.put(lead,pq);
            }
            else{
                PriorityQueue<Character> pq=hs.get(lead);
                pq.add(ch);
                hs.put(lead,pq);
            }
        }

        StringBuilder str=new StringBuilder();
        for(int i=0;i<s.length();i++)
        {
            int lead=find(i);
            if(hs.containsKey(lead))
            {
                str.append(hs.get(lead).remove());
            }
        }
        return str.toString();
    }

    public int find(int x)
    {
        if(parent[x]==x)
            return x;
        int st=find(parent[x]);
        return parent[x]=st;
    }
    public void union(int u,int v)
    {
        int leadu=find(u);
        int leadv=find(v);

        if(leadu!=leadv)
        {
            int ranku=rank[leadu];
            int rankv=rank[leadv];

            if(rankv<ranku)
            {
                parent[leadu]=leadv;
            }
            else if(ranku<rankv)
            {
                parent[leadv]=leadu;
            }
            else{
                parent[leadu]=leadv;
                rank[leadv]++;
            }
        }
    }
}