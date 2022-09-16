class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();

        boolean [][]dp=new boolean[n][n];
        int i=0,j=0;
        for(int g=0;g<dp[0].length;g++)
        {
            for(int si=0,ei=g;ei<dp[0].length;ei++,si++)
            {
                if(g==0)
                {
                    dp[si][ei]=true;

                }
                else if(g==1){
                    dp[si][ei]=s.charAt(si)==s.charAt(ei);
                    if(dp[si][ei])
                        {
                            i=si;
                            j=ei;
                        }
                }
                else{
                    if(s.charAt(si)==s.charAt(ei))
                    {
                        dp[si][ei]=dp[si+1][ei-1] && true;
                        if(dp[si][ei])
                        {
                            i=si;
                            j=ei;
                        }
                    }
                }
            }
        }
        return s.substring(i,j+1);
    }
}