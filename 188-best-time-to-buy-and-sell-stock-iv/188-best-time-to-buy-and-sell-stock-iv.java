class Solution {
    public int maxProfit(int jj, int[] prices) {
        int n=prices.length;
        int [][]dp=new int[jj+1][n+1];
        int ans=0;
        for(int i=1;i<jj+1;i++)
        {
            for(int j=1;j<n+1;j++)
            {
                int max=0;
                for(int k=0;k<j;k++)
                {
                    max=Math.max(max,dp[i-1][k]+prices[j-1]-prices[k]);
                }
                dp[i][j]=Math.max(max,dp[i][j-1]);
                ans=Math.max(ans,dp[i][j]);
            }
        }
        return ans;
    }
}