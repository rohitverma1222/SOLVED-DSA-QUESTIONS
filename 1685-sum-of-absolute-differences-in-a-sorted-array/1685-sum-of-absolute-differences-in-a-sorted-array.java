class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n=nums.length;
        int []pre=new int[nums.length+1];

        for(int i=0;i<n;i++)
        {
            pre[i+1]=pre[i]+nums[i];
        }

        int []ans=new int[n];
        for(int i=0;i<n;i++)
        {
            ans[i]=i*nums[i]-pre[i]+(pre[n]-pre[i]-(n-i)*nums[i]);
        }

        return ans;
    }
}