class Solution {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int oc=grid[row][col];
        helper(grid,row,col,color,grid[row][col]);
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==-oc)
                    grid[i][j]=color;
            }
        }
        return grid;
    }
    public void helper(int [][]grid,int row,int col,int color,int org)
    {
        if(row<0 || col<0 ||row>=grid.length || col>=grid[0].length || grid[row][col]!=org)
            return;


        grid[row][col]=-org;
        // visited[row][col]=true;
        helper(grid,row+1,col,color,org);
        helper(grid,row-1,col,color,org);
        helper(grid,row,col+1,color,org);
        helper(grid,row,col-1,color,org);

        if(row>0 && col>0 && row<grid.length-1 && col<grid[0].length-1 && Math.abs(grid[row-1][col])==org &&  Math.abs(grid[row+1][col])==org && Math.abs(grid[row][col-1])==org && Math.abs(grid[row][col+1])==org )
            grid[row][col]=org;

        return;
    }
    
}