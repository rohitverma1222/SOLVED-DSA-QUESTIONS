class Solution {
    public int closedIsland(int[][] grid) {
       int n=grid.length;
        int m=grid[0].length;
        boolean [][]visited=new boolean[n][m];
        int k=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if( grid[i][j]==0)
                {
                    // c=0;
                    if(enclaves(grid,i,j))
                    {
                        k+=1;
                    }
                }
            }
        }
        return k;
    }
    public boolean enclaves(int [][]grid,int i,int j)
    {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length)
            return false;
        
        if(grid[i][j]==1)
            return true;
        
        grid[i][j]=1;
        
        boolean c1=enclaves(grid,i+1,j);
        boolean c2=enclaves(grid,i-1,j);
        boolean c3=enclaves(grid,i,j+1);
        boolean c4=enclaves(grid,i,j-1);
        
        if(!c1 || !c3 || !c2 || !c4)
            return false;
        
        return true;
        
    }
}