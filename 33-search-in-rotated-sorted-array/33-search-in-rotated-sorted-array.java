class Solution {
    public int search(int[] nums, int target) {
        int l=0;
        int h=nums.length-1;

        while(l<h)
        {
            int mid=(l+h)/2;
            
            if(nums[mid]<nums[h])
            {
                h=mid;
            }
            else if(nums[mid]>nums[h])
            {
                l=mid+1;
            }
            else{
                l--;
            }
        }
        System.out.println(nums[l]);
        // if(nums[l]==target)
        // {
        //     return l;
        // }
        int a=binary(nums,l,nums.length-1,target);
            int b= binary(nums,0,l,target);
        return a>b?a:b;
    }
    public int binary(int []nums,int l,int h,int target)
    {
        while(l<=h)
        {
            int mid=l+(h-l)/2;

            if(nums[mid]==target)
                return mid;
            else if(nums[mid]<target)
            {
                l=mid+1;
            }
            else{
                h=mid-1;
            }
        }
        return -1;
    }
}