class Solution {
    public String longestPalindrome(String s) {
        boolean [][]dp=new boolean[s.length()][s.length()];
        int c=0;
        int i=0;
        int j=0;
        for(int g=0;g<dp.length;g++)
        {
            for(int si=0,ei=g;ei<dp.length;ei++,si++)
            {
                if(g==0)
                {
                    dp[si][ei]=true;
                    i=si;
                    j=ei;
                }
                else if(g==1 && s.charAt(si)==s.charAt(ei))
                {
                    dp[si][ei]=true;
                    i=si;
                    j=ei;
                }
                else{
                    if(s.charAt(si)==s.charAt(ei))
                    {
                        dp[si][ei]=dp[si+1][ei-1] && true;
                    }
                    if(dp[si][ei])
                        {
                            i=si;
                    j=ei;
                        }
                }
            }
        }
        return s.substring(i,j+1);
    }
}