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
                    // flag=true;
                    len=0;
                    if(helper(grid,i,j,visited))
                    {
                        c+=len;
                    }
                    
                }
            }
        }
        return c;
    }
    public boolean helper(int [][]grid,int i,int j,boolean [][]visited)
    {
        if(i<0 || j<0 ||i>=grid.length ||j>=grid[0].length)
        {
            return false;
        }
        else if(visited[i][j]==true || grid[i][j]==0)
            return true;
        
        visited[i][j]=true;
        len++;
        boolean c1=helper(grid,i+1,j,visited);
        boolean c2=helper(grid,i-1,j,visited);
        boolean c3=helper(grid,i,j+1,visited);
        boolean c4=helper(grid,i,j-1,visited);
        if(!c1 || !c2 ||!c3 || !c4)
            return false;
        return true;
    }
}