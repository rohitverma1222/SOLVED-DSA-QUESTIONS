class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int sum=0;
        HashMap<Integer,Integer> hs=new HashMap<>();
        hs.put(sum,1);
        int subarrays=0;
        for(int i:nums)
        {
            sum+=i;
            sum%=k;
            sum+=sum<0?k:0;
            if(hs.containsKey(sum))
                subarrays+=hs.get(sum);
            hs.put(sum,hs.getOrDefault(sum,0)+1);
        }
        return subarrays;
    }
}