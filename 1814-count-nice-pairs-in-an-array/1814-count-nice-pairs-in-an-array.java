class Solution {
    public int countNicePairs(int[] nums) {
        HashMap<Long,Integer> hs=new HashMap<>();
        int sum=0;
    int mod=(int)(Math.pow(10,9)+7);
        for(int i:nums)
        {
            long rev=i-reverse(i);
            if(hs.containsKey(rev))
            {
                sum=((sum%mod)+(hs.get(rev)%mod))%mod;
            }
            hs.put(rev,hs.getOrDefault(rev,0)+1);
        }
        
        return sum;
    }
    public int reverse(int i)
    {
        String str=i+"";
        String ans="";
        for(char ch:str.toCharArray())
        {
            ans=ch+ans;
        }
            // System.out.println(ans);
        return Integer.parseInt(ans);
    }
}