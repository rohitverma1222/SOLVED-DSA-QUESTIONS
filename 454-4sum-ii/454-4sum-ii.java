class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer,Integer> hs=new HashMap<>();
        for(int i=0;i<nums1.length;i++)
        {
            for(int j=0;j<nums1.length;j++)
            {
                int val=nums1[i]+nums2[j];
                hs.put(val,hs.getOrDefault(val,0)+1);
            }
        }
        int ans=0;
        for(int i=0;i<nums1.length;i++)
        {
            for(int j=0;j<nums1.length;j++)
            {
                int val=nums3[i]+nums4[j];
                // hs.put(val,hs.getOrDefault(val,0)+1);
                if(hs.containsKey(-1 * val))
                ans+=hs.get(-1*(val));
            }
        }
        return ans;
    }
}