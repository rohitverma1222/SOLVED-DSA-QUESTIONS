class Solution {
    public int maxProduct(int[] nums) {
        int max=Integer.MIN_VALUE;
        int p=1;
        for(int i=0;i<nums.length;i++)
        {
            p=p*nums[i];

            if(max<p)
                max=p;

            if(nums[i]==0)
                p=1;
        }

         p=1;
        for(int i=nums.length-1;i>=0;i--)
        {
            p=p*nums[i];

            if(max<p)
                max=p;

            if(nums[i]==0)
                p=1;
        }

        return max;
    }
}