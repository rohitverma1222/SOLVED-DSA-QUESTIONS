class Solution {
	int parent[];
	int rank[];
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        parent=new int[s.length()+1];
        rank=new int[s.length()+1];
        for(int i=0;i<s.length()+1;i++)
        {
        	parent[i]=i;
        	rank[i]=0;
        }

        for(List<Integer> li:pairs)
        {
        	int u=li.get(0);
        	int v=li.get(1);

        	union(u,v);
        }

         PriorityQueue<Character> [] pq=new PriorityQueue[s.length()];
         for(int i=0;i<s.length();i++)
         {
         	pq[i]=new PriorityQueue<>();
         }

         for(int i=0;i<s.length();i++)
         {
         	int lead=find(i);

         	char ch=s.charAt(i);
         	pq[lead].add(ch);
         }
         String str="";
         for(int i=0;i<s.length();i++)
         {
         	int lead=find(i);

         	char ch=s.charAt(i);
         	str+=pq[lead].remove();
         }
         return str;

    }
       public int find(int x)
	{
		if(parent[x]==x)
			return x;
		    int st= find(parent[x]);
	       parent[x]=st;
	       return st;
	}
    public void union(int u,int v)
    {
    	int leadu=find(u);
    	int leadv=find(v);
    	if(leadu!=leadv)
    	{
    		if(rank[leadu]<rank[leadv])
    		{
    			parent[leadu]=leadv;
    		}
    		else if(rank[leadv]<rank[leadu])
    		{
    			parent[leadv]=leadu;
    		}
    		else{
    			parent[leadu]=leadv;;
    			rank[leadv]++;
    		}
    	}
    }
}