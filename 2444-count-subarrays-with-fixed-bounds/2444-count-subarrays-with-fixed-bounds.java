class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int st=-1;
        int p_max=-1;
        int p_min=-1;
        int i=0;
        long res=0;
        while(i<nums.length)
        {
            if(nums[i]==minK)
                p_min=i;
            if(nums[i]==maxK)
                p_max=i;
            if(nums[i]>maxK || nums[i]<minK)
                st=i;

            res+=Math.max(0,Math.min(p_max,p_min)-st);
            i++;
        }
        return res;
    }
}