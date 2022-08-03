class Solution {
        HashSet<String> hs;
        String ans="";
    public String findDifferentBinaryString(String[] nums) {
        hs=new HashSet<>();
        for(String str:nums)
            hs.add(str);

        subset(nums[0].length(),"");
        return ans;
        
    }
    public void subset(int n,String str)
    {
        if(n==0)
        {
            if(hs.contains(str)==false)
            {
                ans=str;
                return;
            }
            return;
        }
        subset(n-1,str+"0");
        subset(n-1,str+"1");
    }
}