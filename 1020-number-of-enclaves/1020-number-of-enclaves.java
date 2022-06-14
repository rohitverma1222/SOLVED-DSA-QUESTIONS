class Solution {
    boolean flag=true;
    int len=0;
    public int numEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean [][]visited=new boolean[n][m];
        int c=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(visited[i][j]==false && grid[i][j]==1)
                {
                    flag=true;
                    len=0;
                    helper(grid,i,j,visited);
                    if(flag)
                        c+=len;
                }
            }
        }
        return c;
    }
    public void helper(int [][]grid,int i,int j,boolean [][]visited)
    {
        if(i<0 || j<0 ||i>=grid.length ||j>=grid[0].length)
        {
            flag=false;
            return;
        }
        else if(visited[i][j]==true || grid[i][j]==0)
            return;
        visited[i][j]=true;
        len++;
        helper(grid,i+1,j,visited);
        helper(grid,i-1,j,visited);
        helper(grid,i,j+1,visited);
        helper(grid,i,j-1,visited);
    }
}