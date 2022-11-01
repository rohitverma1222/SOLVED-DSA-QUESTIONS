class Solution {
    HashMap<Integer,List<Integer>> hs;
    Random r=new Random();
    public Solution(int[] nums) {
        hs=new HashMap<>();
        for(int j=0;j<nums.length;j++)
        {
            int i=nums[j];
            if(hs.containsKey(i))
                hs.get(i).add(j);
            else
            {
                List<Integer> hss=new ArrayList<>();
                hss.add(j);
                hs.put(i,hss);
            }
        }
    }
    
    public int pick(int target) {
        return hs.get(target).get(r.nextInt(hs.get(target).size()));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */