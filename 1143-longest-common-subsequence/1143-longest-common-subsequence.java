class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        return helper(text1,text2,0,0,new int[text1.length()+1][text2.length()+1]);
    }
    public int helper(String s1,String s2,int i,int j,int [][]dp)
    {
        if(i>=s1.length() || j>=s2.length())
            return 0;

        if(dp[i][j]!=0)
            return dp[i][j];

        if(s1.charAt(i)==s2.charAt(j))
        {
            return dp[i][j]=1+helper(s1,s2,i+1,j+1,dp);
        }
        else
            return dp[i][j]=Math.max(helper(s1,s2,i+1,j,dp),helper(s1,s2,i,j+1,dp));
    }
}