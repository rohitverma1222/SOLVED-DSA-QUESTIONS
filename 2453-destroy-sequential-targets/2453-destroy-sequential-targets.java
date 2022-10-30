class Solution {
    public int destroyTargets(int[] nums, int space) {
        HashMap<Integer,Integer> hs=new HashMap<>();
        for(int i:nums)
        {
            i%=space;
            hs.put(i,hs.getOrDefault(i,0)+1);
        }
        int ans=(int)1e9;
        int maxi=Collections.max(hs.values());
        for(int i:nums)
        {
            if(hs.get(i%space)==maxi)
                ans=Math.min(ans,i);
        }
        return ans;
    }
}