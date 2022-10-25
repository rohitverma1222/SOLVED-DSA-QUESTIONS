class Solution {
    public long countBadPairs(int[] nums) {
        long n=nums.length;
        HashMap<Long,Long> hs=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            long val=i+1-nums[i];
            hs.put(val,hs.getOrDefault(val,0l)+1);
        }
        
        long sum=0;
        for(long val:hs.values())
        {
            sum+=val*(val-1)/2;
        }
        return n*(n-1)/2-sum;
    }
}