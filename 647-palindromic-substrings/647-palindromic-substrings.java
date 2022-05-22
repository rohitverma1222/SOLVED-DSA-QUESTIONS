class Solution {
    public int countSubstrings(String str) {
         boolean [][]dp=new boolean[str.length()][str.length()];
        int count=0;
        for(int g=0;g<str.length();g++)
        {
            
            for(int i=0,j=g;j<dp.length;j++,i++)
            {
                if(g==0)
                {
                    dp[i][j]=true;
                }
                else if(g==1)
                {
                    dp[i][j]=str.charAt(i)==str.charAt(j);
                }
                else
                {
                    if(str.charAt(i)==str.charAt(j) && dp[i+1][j-1])
                        dp[i][j]=true;
                    else
                        dp[i][j]=false;
                }
                
                if(dp[i][j])
                    count++;
            }
        }
        return count;
    }
}