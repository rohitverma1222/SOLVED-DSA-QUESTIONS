class Solution {
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        if(n==1)
            return nums[0];
        int max=nums[0];
        for(int i=1;i<n;i++)
        {
            
            
            nums[i]=Math.max(nums[i-1]+nums[i],nums[i]);
            
            max=Math.max(nums[i],max);
            
        }
        max=Math.max(nums[n-1],max);
        return max;
    }
}