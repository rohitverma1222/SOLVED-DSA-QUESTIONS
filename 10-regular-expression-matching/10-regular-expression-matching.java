class Solution {
    public boolean isMatch(String s, String p) {
        int n=s.length();
        int m=p.length();
        boolean [][]dp=new boolean[s.length()+1][p.length()+1];

        dp[n][m]=true;

        for(int j=m;j>=0;j--)
        {
            if(j+1<p.length() && p.charAt(j+1)=='*')
                dp[n][j]=dp[n][j+2];
        }

        for(int i=n-1;i>=0;i--)
        {
            for(int j=m-1;j>=0;j--)
            {
                if(j+1<p.length() && p.charAt(j+1)=='*')
                {
                    if(s.charAt(i)==p.charAt(j)||p.charAt(j)=='.'){
                            dp[i][j] = dp[i][j+2] || dp[i+1][j];
                        }
                        else{
                            dp[i][j] = dp[i][j+2];
                        }
                }
                else if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='.')
                    dp[i][j]=dp[i+1][j+1];
            }
        }
        
        // for(boolean i[]:dp)
        // {
        //     for(boolean val:i)
        //         System.out.print(val==true?" T ":" F ");
        //     System.out.println();
        // }
        return dp[0][0];
    }
}