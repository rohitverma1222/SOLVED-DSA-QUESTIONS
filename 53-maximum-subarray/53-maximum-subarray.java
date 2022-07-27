class Solution {
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        int []dp=new int[n];
        if(n==1)
            return nums[0];
        
        // dp[0]=nums[0];
        for(int i=1;i<n;i++)
        {
            
            
            nums[i]=Math.max(nums[i-1]+nums[i],nums[i]);
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<dp.length;i++)
        {
            max=Math.max(nums[i],max);
        }
        return max;
    }
}