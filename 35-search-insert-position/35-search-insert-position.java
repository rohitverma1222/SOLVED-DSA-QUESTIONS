class Solution {
    public int searchInsert(int[] nums, int t) {
        int l=0;
        int h=nums.length-1;
        
        while(l<=h)
        {
            int mid=(l+h)/2;
            
            if(nums[mid]==t)
                return mid;
            else if(nums[mid]<t)
            {
                l=mid+1;
            }
            else {
                h=mid-1;
            }
        }
        return l;
    }
}