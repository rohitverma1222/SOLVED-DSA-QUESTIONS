class Solution {
    public int[] sortedSquares(int[] nums) {
        int ans[]=new int[nums.length];
        int l=0;
        int r=nums.length-1;
        int k=nums.length-1;
        while(l<=r)
        {
            int left=(int)Math.pow(nums[l],2);
            int right=(int)Math.pow(nums[r],2);

            if(left>right)
            {
                ans[k]=left;
                l++;
            }
            else
            {
                ans[k]=right;
                r--;
            }
            k--;
        }
        return ans;
    }
}