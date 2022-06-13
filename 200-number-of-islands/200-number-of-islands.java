class Solution {
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int c=0;
        boolean [][]visited=new boolean[m][n];
        for(int i=0;i<visited.length;i++)
        {
            for(int j=0;j<visited[0].length;j++)
            {
                if(visited[i][j]==false && grid[i][j]=='1')
                {
                    helper(grid,i,j,visited);
                    c++;
                }
            }
        }
        return c;
    }
    public void helper(char []grid[],int i,int j,boolean [][]visited)
    {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]=='0' || visited[i][j]==true)
            return ;
        visited[i][j]=true;
        
        helper(grid,i+1,j,visited);
        helper(grid,i-1,j,visited);
        helper(grid,i,j+1,visited);
        helper(grid,i,j-1,visited);
    }
}