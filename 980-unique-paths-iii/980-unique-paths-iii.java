class Solution {
    int emp=1;
    int res=0;
    public int uniquePathsIII(int[][] grid) {
        int sx=-1;
        int sy=-1;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==0)
                {
                    emp+=1;
                }
                else if(grid[i][j]==1){
                    sx=i;
                    sy=j;
                }
            }
        }
        System.out.println(emp);
        dfs(grid,sx,sy);
        return res;
    }
    public void dfs(int [][]grid,int i,int j)
    {
        if(i<0 || j<0 || i>=grid.length|| j>=grid[0].length || grid[i][j]<0)
            return;
        if(grid[i][j]==2)
        {
            System.out.println(emp);
            if(emp==0)
            {
                res++;
            }
            return;
        }
        
        grid[i][j]=-2;
        emp--;
        
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
        
        grid[i][j]=0;
        emp++;
    }
}