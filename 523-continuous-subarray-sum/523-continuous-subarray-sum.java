class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> hs=new HashMap<>();
        int sum=0;
        hs.put(0,0);
        
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            if(!hs.containsKey(sum%k))
            {
                hs.put(sum%k,i+1);
            }
            else if(hs.get(sum%k)<i)
                return true;
        }
        return false;
    }
}