class Solution {
    public int uniquePaths(int n, int m) {
        int [][]dp=new int[n][m];
        int dir[][]={{1,0},{0,1}};
        dp[n-1][m-1]=1;
        for(int i=n-1;i>=0;i--)
        {
            for(int j=m-1;j>=0;j--)
            {
                for(int d[]:dir)
                {
                    int nr=d[0]+i;
                    int nc=d[1]+j;
                    if(nr>=0 && nc>=0 && nr<n && nc<m)
                        dp[i][j]+=dp[nr][nc];
                }
            }
        }
        return dp[0][0];
    }
}