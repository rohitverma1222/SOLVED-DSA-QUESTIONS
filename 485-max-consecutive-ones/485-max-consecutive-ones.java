class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int j=0;
        int k=0;
        int max=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
            {
                max=Math.max(max,i-j);
                j=i+1;
            }
        }
        max=Math.max(max,nums.length-j);
        return max;
    }
}