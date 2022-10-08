class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum=0;
        HashMap<Integer,Integer> hs=new HashMap<>();
        hs.put(sum,1);
        int subarrays=0;
        for(int i:nums)
        {
            sum+=i;
            if(hs.containsKey(sum-k))
                subarrays+=hs.get(sum-k);
            hs.put(sum,hs.getOrDefault(sum,0)+1);
        }
        return subarrays;
    }
}