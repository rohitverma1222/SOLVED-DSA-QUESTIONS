class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int c=0;
        boolean visited[][]=new boolean[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(visited[i][j]==false && grid[i][j]=='1')
                {
                    c++;
                    helper(grid,i,j,visited);
                }
            }
        }
        return c;
    }
    int dir[][]={{1,0},{-1,0},{0,-1},{0,1}};
    public void helper(char [][]board,int i,int j,boolean visited[][])
    {
        visited[i][j]=true;

        for(int []d:dir)
        {
            int ni=i+d[0];
            int nj=j+d[1];
            if(ni>=0 && nj>=0 && ni<board.length && nj<board[0].length && visited[ni][nj]==false && board[ni][nj]=='1')
                helper(board,ni,nj,visited);
        }
        // visited[i][j]=false;
    }
}