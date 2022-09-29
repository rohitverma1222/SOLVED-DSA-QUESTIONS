class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int n=dungeon.length;
        int m=dungeon[0].length;
        int [][]dp=new int[n][m];
        for(int i=n-1;i>=0;i--)
        {
            for(int j=m-1;j>=0;j--)
            {
                int min=Integer.MAX_VALUE;
                if(i==n-1 && j==m-1)
                {
                    min=1;
                }
                else if(i==n-1)
                {
                    min=dp[i][j+1];
                }
                else if(j==m-1)
                {
                    min=dp[i+1][j];
                }
                else{
                    min=Math.min(dp[i][j+1],dp[i+1][j]);
                }
                dp[i][j]=Math.max(1,min-dungeon[i][j]);
            }
        }
        return dp[0][0];
    }
}