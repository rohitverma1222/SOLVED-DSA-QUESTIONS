class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        return helper(strs,0,m,n,new int[strs.length+1][m+1][n+1]);
    }
    public int helper(String []str,int i,int m,int n,int dp[][][])
    {
        if(i>=str.length)
        {
            return 0;
        }
        else if(dp[i][m][n]!=0)
            return dp[i][m][n];
        int first = helper(str,i+1,m,n,dp);
        
        String word=str[i];
        int one=0;
        int zero=0;
        for(char ch:word.toCharArray())
        {
            if(ch=='0')
                zero++;
            else
                one++;
        }
        int sec=0;
        if(m-zero>=0 && n-one>=0)
            sec=1+helper(str,i+1,m-zero,n-one,dp);
        return dp[i][m][n] = Math.max(first,sec);
    }
}