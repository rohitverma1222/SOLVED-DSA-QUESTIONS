class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int c=0;
        HashMap<Integer,Integer> hs=new HashMap<>();
        hs.put(0,1);
        int sum=0;
        for(int i:nums)
        {
            sum+=i;
            sum=sum%k;
            
            if(sum<0)
                sum+=k;
            int ans=0;
            hs.put(sum,(ans=hs.getOrDefault(sum,0))+1);
            c+=ans;
        }
        return c;
    }
}