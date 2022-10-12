class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int []inOut=new int[n];

        for(int i[]:roads)
        {
            int u=i[0];
            int v=i[1];
            inOut[u]++;
            inOut[v]++;
        }
        
        // PriorityQueue<Long> pq=new PriorityQueue<>();
        HashMap<Integer,Integer> hs=new HashMap<>();
        int idx=0;
        for(int i:inOut)
        {
            hs.put(i,hs.getOrDefault(i,0)+1);
        }

        long maxValue=1;
        long sum=0;
        for(int i=0;i<n;i++)
        {
            if(hs.containsKey(i))
            {
                int val=hs.get(i);
                while(val-->0)
                {
                    sum+=i*maxValue++;
                }
            }
            
        }
        return sum;
    }
}