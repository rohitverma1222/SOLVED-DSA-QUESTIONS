class Solution {
    public int longestSubarray(int[] nums) {
        int p=-1;
        int left=0;
        int right=0;
        int max=0;
        int x=0;
        int y=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
            {
                left=p+1;
                p=i;
            }
            right=i;
            if(max<right-left+1)
            {
                max=right-left+1;
                x=right;
                y=left;
            }
        }
        int c=0;
        for(int i=y;i<x+1;i++)
        {
            System.out.print(nums[i]);
            if(nums[i]==1)
                c++;
        }
        if(p==-1)
            return c-1;
        return c;
    }
}