class Solution {
    int c=0;
    public int numEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean [][]visited=new boolean[n][m];
        int k=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(visited[i][j]==false && grid[i][j]==1)
                {
                    c=0;
                    if(enclaves(grid,visited,i,j))
                    {
                        k+=c;
                    }
                }
            }
        }
        return k;
    }
    public boolean enclaves(int [][]grid,boolean [][]visited,int i,int j)
    {
        if(i<0 ||j<0 || i>=grid.length || j>=grid[0].length)
            return false;
        else if(visited[i][j]==true || grid[i][j]==0)
            return true;
        
        c++;
        visited[i][j]=true;
        boolean c1= enclaves(grid,visited,i+1,j);
        boolean c2=enclaves(grid,visited,i-1,j);
         boolean c3=enclaves(grid,visited,i,j+1);
       boolean c4= enclaves(grid,visited,i,j-1);
        
        if(c1==false ||!c2 || !c3 ||!c4)
            return false;
        return true;
    }
}