class Solution {
    public int waysToSplitArray(int[] nums) {
        long sum=0;
        for(int v:nums)
            sum+=v;
        long local=0;
        int c=0;
        for(int i=0;i<nums.length-1;i++)
        {
            local+=nums[i];
            if(local>=sum-local)
                c++;
        }
        return c;
    }
}