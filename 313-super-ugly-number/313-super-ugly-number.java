class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        long []dp=new long[n+1];
        dp[0]=0;
        dp[1]=1;

        int idx[]=new int[primes.length];
        Arrays.fill(idx,1);

        for(int i=2;i<dp.length;i++)
        {
            long min=Long.MAX_VALUE;
            for(int j=0;j<primes.length;j++)
            {
                min=Math.min(primes[j]*dp[idx[j]],min);
            }
            dp[i]=min;
            for(int j=0;j<primes.length;j++)
            {
                if(primes[j]*dp[idx[j]]==min)
                {
                    idx[j]++;
                }
            }
        }
        return (int)dp[n];
    }
}