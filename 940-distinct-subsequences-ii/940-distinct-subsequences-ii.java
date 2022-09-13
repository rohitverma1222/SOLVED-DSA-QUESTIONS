class Solution {
    long mod=1000000007;
    public int distinctSubseqII(String s) {
        long []dp=new long[s.length()+1];
        dp[0]=1;
        int []lastIndex=new int[26];
        for(int i=1;i<dp.length;i++)
        {
            char ch=s.charAt(i-1);
            int idx=lastIndex[ch-'a']-1>=0 ? lastIndex[ch-'a']-1:-1;
            if(idx<0)
                dp[i]=(2*dp[i-1])%mod;
            else
                dp[i]=(2*dp[i-1]-dp[idx]+mod)%mod;
            
            lastIndex[ch-'a']=i;
        }
        return (int)(dp[s.length()]-1);
    }
}