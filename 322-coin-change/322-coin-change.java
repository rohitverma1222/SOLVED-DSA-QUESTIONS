class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount==0)
            return 0;
        int []dp=new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        for(int i=1;i<dp.length;i++)
        {
            for(int c:coins)
            {
                if(i>=c)
                {
                    dp[i]=Math.min(dp[i],dp[i-c]+1);
                }
            }
        }
        return dp[amount]==amount+1 ? -1 : dp[amount];
    }
}