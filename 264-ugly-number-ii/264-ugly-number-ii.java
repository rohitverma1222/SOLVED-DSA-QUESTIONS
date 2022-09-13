class Solution {
    public int nthUglyNumber(int n) {
        int []dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        int i2=1,i3=1,i5=1;
        for(int i=2;i<dp.length;i++)
        {

            int a2=dp[i2]*2;
            int a3=dp[i3]*3;
            int a5=dp[i5]*5;

            int min=Math.min(a2,Math.min(a3,a5));
            dp[i]=min;
            if(dp[i2]*2==min)
                i2++;
            if(dp[i3]*3==min)
                i3++;

            if(dp[i5]*5==min)
                i5++;
            
        }
        return dp[n];
    }
}