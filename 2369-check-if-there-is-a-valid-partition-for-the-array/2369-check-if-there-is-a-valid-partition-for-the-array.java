class Solution {
    public boolean validPartition(int[] nums) {

        boolean []dp=new boolean[nums.length+1];
        dp[0]=true;
        // dp[1]=true;
        for(int i=2;i<dp.length;i++)
        {
            boolean ans=nums[i-1]==nums[i-2] && dp[i-2];

            if(i>2)
            {
                ans=ans||(nums[i-1]==nums[i-2] && nums[i-2]==nums[i-3] && dp[i-3]); 
                ans=ans||(nums[i-1]-nums[i-2]==1 && nums[i-2]-nums[i-3]==1 && dp[i-3]);
            }
            dp[i]=ans;
        }
        return dp[nums.length];
    }
}