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
        PriorityQueue<Long> pq=new PriorityQueue<>();

        for(int i:inOut)
            pq.add((long)i);

        long i=1;
        long sum=0;
        while(pq.size()!=0)
        {
            sum+=pq.remove()*i++;
        }
        return sum;
    }
}