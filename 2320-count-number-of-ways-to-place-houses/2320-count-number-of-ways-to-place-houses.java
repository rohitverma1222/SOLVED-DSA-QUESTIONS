class Solution {
    long m = 1000000007;
    
    public int countHousePlacements(int n) {
        if(n==1)
            return 4;
        if(n==2)
            return 9;
        long []dp=new long[n+1];
        dp[0]=1;
        dp[1]=2;
        for(int i=2;i<n+1;i++)
        {
            dp[i]=(dp[i-1]+dp[i-2]) %m;
        }
        return (int)((dp[n]*dp[n])%m);
    }
}
