class Solution {
    public int[] productExceptSelf(int[] nums) {
        int []left=new int[nums.length];
        left[0]=1;
        for(int i=1;i<nums.length;i++)
        {
            left[i]=nums[i-1]*left[i-1];
        }


        int []ans=new int[nums.length];
        ans[nums.length-1]=left[nums.length-1];
        int right=1;
        for(int i=nums.length-2;i>=0;i--)
        {
            right=nums[i+1]*right;
            ans[i]=right*left[i];
            // System.out.println(nums[i+1]*right);
        }
        return ans;
    }
}