class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int c=0;
        int n=grid1.length;
        int m=grid1[0].length;
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid2[i][j]==1)
                {
                    if(solve(grid1,grid2,i,j))
                        c++;
                }
            }
        }
        return c;
    }
    public boolean solve(int [][]grid1,int [][]grid2,int i,int j)
    {
        if(i<0 || j<0 || i>=grid1.length|| j>=grid1[0].length || grid2[i][j]==0)
            return true;
        
        boolean flag=grid1[i][j]==1;
        
        grid2[i][j]=0;
        
        boolean c1=solve(grid1,grid2,i+1,j);
        boolean c2=solve(grid1,grid2,i-1,j);
        boolean c3=solve(grid1,grid2,i,j-1);
        boolean c4=solve(grid1,grid2,i,j+1);
        if(!flag ||!c1 || !c2 || !c3 || !c4)
        {
            return false;
        }
        return true;
    }
}