class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0)=='0')
            return 0;
        
        return helper(0,s,new Integer[s.length()]);
    }
    public int helper(int i,String s,Integer []dp)
    {
        if(i>=s.length())
            return 1;
        else if(dp[i]!=null) return dp[i];
        if(s.charAt(i)=='0') return 0;
        int res=helper(i+1,s,dp);
        if(i<s.length()-1 && (s.charAt(i)=='1' || s.charAt(i)=='2' && s.charAt(i+1)<'7'))
            res+=helper(i+2,s,dp);
        return dp[i]=res;
    }
}