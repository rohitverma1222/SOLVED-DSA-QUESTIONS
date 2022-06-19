class Solution {
    class pair{
        int x;
        int y;
        pair(int x,int y)
        {
            this.x=x;
            this.y=y;
        }
    }
        int max=0;
    public int maxAreaOfIsland(int[][] grid) {
        boolean [][]visited=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1 && visited[i][j]==false)
                {
                    int m=bfs(grid,i,j,visited);
                    max=Math.max(m,max);
                }
            }
        }
       
        return max;
    }
    int [][]dir={{1,0},{-1,0},{0,-1},{0,1}};
    public int bfs(int [][]grid,int i,int j,boolean [][]visited)
    {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]!=1 || visited[i][j]==true)
            return 0;
        int ans=0;
        visited[i][j]=true;
        
        ans+=bfs(grid,i+1,j,visited);
        ans+=bfs(grid,i-1,j,visited);
        ans+=bfs(grid,i,j+1,visited);
        ans+=bfs(grid,i,j-1,visited);
        
        return ans+1;
    }
}






