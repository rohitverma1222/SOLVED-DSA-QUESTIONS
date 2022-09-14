class Solution {
    long mod=1000000007;
    public int distinctSubseqII(String s) {
        int n=s.length();
        long []dp=new long[n+1];
        dp[0]=1;
        dp[1]=2;
        int last[]=new int[26];
        last[s.charAt(0)-'a']=1;

        for(int i=2;i<dp.length;i++)
        {
            dp[i]=( dp[i-1]*2 ) %mod;

            int ch=s.charAt(i-1)-'a';
            if(last[ch]!=0)
            {
                dp[i]=(dp[i]-dp[last[ch]-1]+mod)%mod;
            }
            last[ch]=i;
        }
        return (int)dp[n]-1;
    }
}