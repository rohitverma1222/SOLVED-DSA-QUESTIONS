class Solution {
    public int[] twoSum(int[] nums, int tar) {
        int i=0;
        int j=nums.length-1;
        int []ans=new int[2];
        while(i<j)
        {
            if(tar==nums[i]+nums[j])
            {
                ans[0]=i+1;
                ans[1]=j+1;
                return ans;
            }
            else if(tar<nums[i]+nums[j])
            {
                j--;
            }
            else
                i++;
        }
        return new int[0];
    }
}