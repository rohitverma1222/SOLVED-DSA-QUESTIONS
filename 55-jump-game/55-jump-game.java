class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        boolean dp[]=new boolean[n];
        dp[n-1]=true;
        for(int i=n-1;i>=0;i--)
        {
//             for(int j=1;j<=nums[i];j++)
//             {
//                 if(i+j<n)
//                 {
//                     dp[i] =dp[i]|| dp[i+j];
                    
//                     if(dp[i])
//                         break;
//                 }
//             }
            int j=1;
            while(j<=nums[i] && i+j<n)
            {
                dp[i] =dp[i]|| dp[i+j];
                    
                    if(dp[i])
                        break;
                j++;
            }
        }
        return dp[0];
    }
}