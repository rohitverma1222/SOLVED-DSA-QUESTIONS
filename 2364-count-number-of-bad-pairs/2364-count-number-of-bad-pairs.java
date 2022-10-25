class Solution {
    public long countBadPairs(int[] nums) {
        HashMap<Long,Integer> hs=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            long val=i+1-nums[i];
            hs.put(val,hs.getOrDefault(val,0)+1);
        }
        
        long sum=0;
        for(long val:hs.values())
        {
            sum+=val*(val-1)/2;
        }
        long total=nums.length;
        total*=(nums.length-1);
        total/=2;
        return total-sum;
    }
}