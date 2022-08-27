class FindSumPairs {
    int nums1[];
int nums2[];
        HashMap<Integer,Integer> hs=new HashMap<>();

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1=nums1;
        this.nums2=nums2;
        for(int i:nums2)
        {
            hs.put(i,hs.getOrDefault(i,0)+1);
        }
    }
    
    public void add(int index, int val) {
        hs.put(nums2[index],hs.get(nums2[index])-1);
        nums2[index]+=val;
        hs.put(nums2[index],hs.getOrDefault(nums2[index],0)+1);
    }
    
    public int count(int val) {
        int tt=0;
        for(int i:nums1)
        {
            if(hs.containsKey(val-i))
            {
                tt+=hs.get(val-i);
            }
        }
        return tt;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */