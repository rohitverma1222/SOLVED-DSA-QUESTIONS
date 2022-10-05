class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first=-1;
        int last=-1;
        int left=0;
        int right=nums.length-1;
        while(left<=right)
        {
            int mid=(left+right)/2;
            if(target<=nums[mid])
            {
                right=mid-1;
            }
            else{
                left=mid+1;
            }
            if(nums[mid]==target){
                last=mid;
            }
        }
        System.out.println(last);
        left=0;
        right=nums.length-1;
        while(left<=right)
        {
            int mid=(left+right)/2;
            if(target>=nums[mid])
            {
                left=mid+1;
            }
            else{
                right=mid-1;
            }
            if(nums[mid]==target){
                first=mid;
            }
        }
        return new int[]{last,first};
    }
}