class Solution {
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        if(n==0)
            return 0;
        int [][]dp=new int[k+1][n];
        for(int i=1;i<dp.length;i++)
        {
                int max=Integer.MIN_VALUE;
            for(int j=1;j<dp[0].length;j++)
            {
                int val=dp[i-1][j-1]-prices[j-1];
                max=Math.max(max,val);
                dp[i][j]=Math.max(dp[i][j-1],max+prices[j]);
            }
        }
        return dp[k][n-1];
    }
}