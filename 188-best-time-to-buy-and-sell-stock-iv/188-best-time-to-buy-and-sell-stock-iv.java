class Solution {
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        if(n==0)
            return 0;
        int [][]dp=new int[k+1][n];
        for(int i=1;i<dp.length;i++)
        {
            for(int j=1;j<dp[0].length;j++)
            {
                int max=0;
                for(int jj=0;jj<j;jj++)
                {
                    max=Math.max(max,dp[i-1][jj]+prices[j]-prices[jj]);
                }
                dp[i][j]=Math.max(dp[i][j-1],max);
            }
        }
        return dp[k][n-1];
    }
}