class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i:nums)
        {
            sum+=i;
        }

        if(sum%2==1)
            return false;

        return targetSum(nums,sum/2);
    }
    public boolean targetSum(int []nums,int target)
    {
        boolean [][]dp=new boolean[nums.length+1][target+1];

        for(int i=1;i<dp.length;i++)
        {
            for(int j=0;j<dp[0].length;j++)
            {
                if(j==0)
                {
                    dp[i][j]=true;
                    continue;
                }
                if(j-nums[i-1]>=0)
                    dp[i][j]=dp[i-1][j] || dp[i-1][j-nums[i-1]];
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[nums.length][target];
    }
}