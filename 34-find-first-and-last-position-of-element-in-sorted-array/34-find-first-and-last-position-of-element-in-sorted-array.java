class Solution {
    public int[] searchRange(int[] nums, int target) {
        int i=0;
        int j=nums.length-1;
        int p=-1;
        boolean flag=false;
        while(i<=j)
        {
            int mid=(i+j)/2;
            
            if(nums[mid]==target)
            {
                flag=true;
                p=mid;
                break;
            }
            else if(nums[mid]<target){
                i=mid+1;
            }
            else
                j=mid-1;
        }
        i=j=p;
        System.out.println(i+" "+j);
        while(i>=0 && i<nums.length && nums[i]==nums[p])
            i--;
        
        while(j>=0 && j<nums.length&&nums[j]==nums[p])
            j++;
        if(flag)
            return new int[]{i+1,j-1};
        return new int[]{-1,-1};
    }
}