class Solution {
    public int countVowelPermutation(int n) {
        int mod=1000_000_007;
        long []dp=new long[5];
        Arrays.fill(dp,1);

        long ans[]=new long[5];
        for(int i=0;i<n-1;i++)
        {
            ans[0]=(dp[1])%mod;

            ans[1]=(dp[0]+dp[2])%mod;

            ans[2]=(dp[0]+dp[1]+dp[3]+dp[4])%mod;

            ans[3]=(dp[2]+dp[4])%mod;

            ans[4]=(dp[0])%mod;

            dp=ans;
            ans=new long[5];
        }
        long sum=0;
        
        for(long i:dp)
        {
            sum=(sum+i)%mod;
        }
        return (int)sum;
        
    }
}