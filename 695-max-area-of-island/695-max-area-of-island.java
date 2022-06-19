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
                if(grid[i][j]==1)
                {
                    int m=bfs(grid,i,j,visited);
                    // visited[i][j]=true;
                    max=Math.max(m,max);
                }
            }
        }
       
        return max;
    }
    public int bfs(int [][]grid,int i,int j,boolean [][]visited)
    {
        int ans=1;
        Queue<pair> mq=new LinkedList<>();
         int n=grid.length;
        int m=grid[0].length;
        int [][]dir={{-1,0},{1,0},{0,-1},{0,1}};
        mq.add(new pair(i,j));
        grid[i][j]=2;
        while(mq.size()>0)
        {
            int size=mq.size();
            while(size-->0)
            {
                pair rem=mq.remove();
                
                for(int []d:dir)
                {
                    int ni=rem.x+d[0];
                    int nj=rem.y+d[1];
                    if(ni>=0 && nj>=0 && ni<n && nj<m && grid[ni][nj]==1)
                    {
                        mq.add(new pair(ni,nj));
                        grid[ni][nj]=2;
                        ans++;
                        // System.out.println(ans+" "+ni+" "+nj);
                    }
                }
            }
        }
        return ans;
    }
    
}