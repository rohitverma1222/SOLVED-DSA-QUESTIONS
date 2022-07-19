class Solution {
    public int subarraySum(int[] nums, int k) {
        int s=0;
        HashMap<Integer,Integer> hs=new HashMap<>();
        int t=0;
        hs.put(0,1);
        for(int i:nums)
        {
            t+=i;
            if(hs.containsKey(t-k))
                s+=hs.get(t-k);
            hs.put(t,hs.getOrDefault(t,0)+1);
        }
        return s;
    }
}