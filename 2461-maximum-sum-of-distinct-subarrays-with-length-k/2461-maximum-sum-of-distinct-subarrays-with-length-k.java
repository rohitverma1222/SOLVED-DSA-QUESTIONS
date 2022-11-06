class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> hs=new HashMap<>();
        long sum=0;
        long max=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            hs.put(nums[i],hs.getOrDefault(nums[i],0)+1);
            
            if(i>=k-1)
            {
                if(hs.size()==k)
                    max=Math.max(max,sum);
                sum-=nums[i-k+1];
                hs.put(nums[i-k+1],hs.getOrDefault(nums[i-k+1],0)-1);
                if(hs.get(nums[i-k+1])==0)
                    hs.remove(nums[i-k+1]);
            }
        }
        return max;
    }
}