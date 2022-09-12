class Solution {
    boolean [][]isPal;
    void Palindrome(String s)
    {
        int n=s.length();

        isPal=new boolean[s.length()][s.length()];

        for(int g=0;g<isPal[0].length;g++)
        {
            for(int si=0,ei=g;ei<n;ei++,si++)
            {
                if(g==0)
                {
                    isPal[si][ei]=true;
                }
                else if(g==1)
                {
                    isPal[si][ei]=s.charAt(ei)==s.charAt(si);
                }
                else{
                    isPal[si][ei] = s.charAt(ei) == s.charAt(si) && isPal[si + 1][ei - 1] == true; ;
                }
            }
        }
    }
    public int minCut(String s) {
        if(s.length()==1)
            return 0;
        Palindrome(s);

        int []dp=new int[s.length()];
        dp[0]=0;
        dp[1]=s.charAt(1)==s.charAt(0)?0:1;
        for(int j=2;j<dp.length;j++)
        {
            dp[j]=j;

            if(isPal[0][j])
                dp[j]=0;
            else{
                for(int i=j;i>0;i--)
                {
                    if(isPal[i][j])
                    {
                        dp[j]=Math.min(dp[j],dp[i-1]+1);
                    }
                }
            }
        }
        return dp[dp.length-1];
    }
}