class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return an(nums,k)-an(nums,k-1);
    }
    public int an(int []nums,int k)
    {
        HashMap<Integer,Integer> hs=new HashMap<>();
        int ans=0;
        int i=0;
        int j=0;
        while(i<nums.length)
        {
            hs.put(nums[i],hs.getOrDefault(nums[i],0)+1);
            while(hs.size()==k+1)
            {
               hs.put(nums[j],hs.get(nums[j])-1);
                if(hs.get(nums[j])==0)
                    hs.remove(nums[j]);
                j++;
            }
            ans+=i-j+1;
            i++;
        }
        return ans;
    }
}