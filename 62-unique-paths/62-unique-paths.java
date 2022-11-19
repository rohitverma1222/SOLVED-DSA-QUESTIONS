class Solution {
    public int uniquePaths(int n, int m) {
        int [][]dp=new int[n][m];
        int dir[][]={{1,0},{0,1}};
        
        return mazePath(0,0,n-1,m-1,dp,dir);
    }
    public int mazePath(int sr,int sc,int er,int ec,int [][]dp,int [][]dir)
    {
        for(int i=er;i>=sr;i--)
        {
            for(int j=ec;j>=sc;j--)
            {
                if(i==er && j==ec)
                {
                    dp[i][j]=1;
                    continue;
                }

                int count=0;

                for(int d[]:dir)
                {
                    int nr=d[0]+i;
                    int nc=d[1]+j;
                    if(nr>=0 && nc>=0 && nr<dp.length && nc <dp[0].length)
                        count+=dp[nr][nc];
                }
                dp[i][j]=count;
            }
        }
        return dp[0][0];
    }
}