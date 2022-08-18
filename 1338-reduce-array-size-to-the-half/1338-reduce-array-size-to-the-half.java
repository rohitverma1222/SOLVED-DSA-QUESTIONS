class Solution {
    public int minSetSize(int[] arr) {
        HashMap<Integer,Integer> hs=new HashMap<>();
        for(int i:arr)
        {
            hs.put(i,hs.getOrDefault(i,0)+1);
        }        

        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)-> {
            return b-a;
        });

        for(int i:hs.values())
        {
            pq.add(i);
        }
        int e=0;
        int set=0;

        while(pq.size()!=0)
        {
            e+=pq.remove();
            set++;
            if(e>=arr.length/2)
                return set;
        }
        return set;
    }
}