class Solution {
    class pair implements Comparable<pair>{
        char ch;
        int f;
        pair(char ch,int f)
        {
            this.ch=ch;
            this.f=f;
        }
        public int compareTo(pair other)
        {
            return other.f-this.f;
        }
    }
    public String reorganizeString(String s) {
        int len=s.length();
        HashMap<Character,Integer> hs=new HashMap<>();
        for(char ch:s.toCharArray())
        {
            hs.put(ch,hs.getOrDefault(ch,0)+1);
        }
        
        PriorityQueue<pair> pq=new PriorityQueue<>();
        for(char i:hs.keySet())
        {
            pq.add(new pair(i,hs.get(i)));
        }
        
        StringBuilder str=new StringBuilder();
        pair prev=null;
        while(pq.size()!=0)
        {
            pair rem=pq.remove();
            str.append(rem.ch);
            
            rem.f--;
            
            if(prev!=null)
                pq.add(prev);
            
            if(rem.f>0)
                prev=rem;
            else
                prev=null;
        }
        return str.toString().length()==len? str.toString():"";
    }
}