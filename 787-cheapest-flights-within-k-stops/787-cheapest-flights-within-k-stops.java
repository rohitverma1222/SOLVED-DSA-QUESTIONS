class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) 
    {
        // Write your code here
        
        int []paths=new int[n];
        Arrays.fill(paths,Integer.MAX_VALUE);
        paths[src]=0;
        int ans=0;
        for(int i=0;i<=k;i++)
        {
            int dp[]=paths.clone();
            for(int j=0;j<flights.length;j++)
            {
                int u=flights[j][0];
                int v=flights[j][1];
                int wt=flights[j][2];

                if(paths[u]==Integer.MAX_VALUE)
                    continue;

                if(paths[u]+wt<dp[v]){
                    dp[v]=paths[u]+wt;
                }
            }
            paths=dp;
        }
        if( paths[dst]==Integer.MAX_VALUE)
            return -1;
        return paths[dst];
            
    }
}