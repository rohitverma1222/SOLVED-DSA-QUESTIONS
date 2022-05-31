class Solution {
    public int rob(int[] nums) {
        int in=nums[0];
        int ex=0;
        for(int i=1;i<nums.length;i++)
        {
            int p=in;
            in=ex+nums[i];
            ex=Math.max(ex,p);
        }
        return Math.max(in,ex);
    }
}