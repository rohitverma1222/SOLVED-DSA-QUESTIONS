class Solution {
    public int countSubstrings(String s) {
        boolean [][]dp=new boolean[s.length()][s.length()];
        int c=0;
        for(int g=0;g<dp.length;g++)
        {
            for(int si=0,ei=g;ei<dp.length;ei++,si++)
            {
                if(g==0)
                {
                    dp[si][ei]=true;
                    c++;
                }
                else if(g==1 && s.charAt(si)==s.charAt(ei))
                {
                    dp[si][ei]=true;
                    c++;
                }
                else{
                    if(s.charAt(si)==s.charAt(ei))
                    {
                        dp[si][ei]=dp[si+1][ei-1] && true;
                    }
                    if(dp[si][ei])
                        c++;
                }
            }
        }
        return c;
    }
}