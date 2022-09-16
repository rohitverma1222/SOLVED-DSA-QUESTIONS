class Solution {
    public int jump(int[] nums) {
        int []dp=new int[nums.length];

        dp[nums.length-1]=0;
        for(int i=dp.length-2;i>=0;i--)
        {
            // if(nums[i]>0)
            // {
                int min=10000;
                for(int j=1;j<=nums[i];j++)
                {
                    if(i+j<dp.length)
                        min=Math.min(min,dp[i+j]);
                }
                dp[i]=min+1;
            // }
        }
        return dp[0];
    }
}