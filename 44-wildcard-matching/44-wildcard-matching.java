class Solution {
    public boolean isMatch(String s, String pat) {
        int n=s.length();
        int m=pat.length();
        boolean [][]dp=new boolean[n+1][m+1];
        dp[n][m]=true;
        for(int j=m-1;j>=0;j--)
        {
            if(pat.charAt(j)=='*')
            {
                dp[n][j]=dp[n][j+1];
            }
        }
        for(int i=n-1;i>=0;i--)
        {
            for(int j=m-1;j>=0;j--)
            {
                    if(pat.charAt(j)=='?' )
                    {
                        dp[i][j]=dp[i+1][j+1];
                    }
                    else if(pat.charAt(j)=='*')
                    {
                        dp[i][j]=dp[i+1][j] || dp[i][j+1];
                    }
                    else if(s.charAt(i)==pat.charAt(j))
                    {
                        dp[i][j]=dp[i+1][j+1];
                    }
            }
        }
        return dp[0][0];
    }
}