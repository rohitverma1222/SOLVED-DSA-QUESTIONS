class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first=findFirst(nums,target);
        int last=findLast(nums,target);
        return new int[]{first,last};
    }
    public int findFirst(int []nums,int target)
    {
        int l=0;
        int r=nums.length-1;
        int idx=-1;
        while(l<=r)
        {
                        int mid=(l+r)/2;

            if(target<=nums[mid])
            {
                r=mid-1;
            }
            else{
                l=mid+1;
            }
            if(nums[mid]==target)
                idx=mid;
        }
        return idx;
    }

    public int findLast(int []nums,int target)
    {
        int l=0;
        int r=nums.length-1;
        int idx=-1;
        while(l<=r)
        {
            int mid=(l+r)/2;
            if(target>=nums[mid])
            {
                l=mid+1;
            }
            else{
                r=mid-1;
            }
            if(nums[mid]==target)
                idx=mid;
        }
        return idx;
    }
}