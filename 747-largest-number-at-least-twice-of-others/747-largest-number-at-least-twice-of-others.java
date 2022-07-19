class Solution {
    public int dominantIndex(int[] nums) {
        int f=-1;
        int s=-1;

        for(int i=0;i<nums.length;i++)
        {
            if(f==-1|| nums[i]>=nums[f])
            {
                s=f;
                f=i;
            }
            else if(s==-1 || nums[i]>=nums[s])
            {
                s=i;
            }
        }
        
        if(nums[f]>=nums[s]*2)
            return f;
        return -1;
    }
}