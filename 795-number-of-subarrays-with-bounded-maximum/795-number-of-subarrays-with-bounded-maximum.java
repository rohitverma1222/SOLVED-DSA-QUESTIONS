class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int c=0;
        int e=-1;
        int s=-1;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>=left && nums[i]<=right)
            {
                e=i;
            }
            else if(nums[i]>right){
                s=e=i;
            }
            c+=(e-s);
        }
        return c;
    }
}