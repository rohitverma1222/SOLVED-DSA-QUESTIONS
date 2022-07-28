class Solution {
    public int firstMissingPositive(int[] nums) {
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>nums.length|| nums[i]<=0)
                nums[i]=nums.length+1;
        }

        for(int i=0;i<nums.length;i++)
        {
            int val=Math.abs(nums[i]);

            if(val<=nums.length)
            {
                if(nums[val-1]>0)
                nums[val-1]*=-1;
            }
        }

        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>0)
                return i+1;
        }
        return nums.length+1;
    }
}