class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        boolean dp[]=new boolean[n];
        dp[n-1]=true;
        for(int i=n-1;i>=0;i--)
        {
            int j=1;
            while(j<=nums[i])
            {
                if(i+j<n)
                    dp[i] =dp[i]|| dp[i+j];
                    
                    if(dp[i])
                        break;
                j++;
            }
        }
        return dp[0];
    }
}