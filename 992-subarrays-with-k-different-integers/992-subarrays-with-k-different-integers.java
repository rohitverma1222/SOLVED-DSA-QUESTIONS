class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return AtmostSubarr(nums,k)- AtmostSubarr(nums,k-1);
    }
    public int AtmostSubarr(int []nums,int k)
    {
        int max=0;
        Map<Integer,Integer> hs=new HashMap<>();
        int j=0;
        for(int i=0;i<nums.length;i++)
        {
            hs.put(nums[i],hs.getOrDefault(nums[i],0)+1);
            while(hs.size()>k)
            {
                hs.put(nums[j],hs.get(nums[j])-1);
                if(hs.get(nums[j])==0)
                    hs.remove(nums[j]);

                j++;
            }
            max+=(i-j+1);
        }
        return max;
    }
}