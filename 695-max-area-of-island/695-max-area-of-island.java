class Solution {
    int max;
    class pair{
        int x;
        int y;
        pair(int x,int y)
        {
            this.x=x;
            this.y=y;
        }
    }
    public int maxAreaOfIsland(int[][] grid) {

        max=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    int val=bfs(grid,i,j);
                    // System.out.println(val);
                    max=Math.max(val,max);
                }
            }
        }
        return max;
    }
    int [][]dir={{1,0},{-1,0},{0,1},{0,-1}};
    public int bfs(int [][]grid,int i,int j)
    {
        Queue<pair> mq=new LinkedList<>();
        mq.add(new pair(i,j));
        boolean flag=false;
        int c=0;
        grid[i][j]=2;
        while(mq.size()>0)
        {
            int s=mq.size();
            while(s-->0)
            {
                pair rem=mq.remove();
                c++;

                for(int d[]:dir)
                {
                    int ni=rem.x+d[0];
                    int nj=rem.y+d[1];

                    if(ni>=0 && nj>=0 && ni<grid.length && nj<grid[0].length && grid[ni][nj]==1)
                    {
                        mq.add(new pair(ni,nj));
                        grid[ni][nj]=2;
                    }
                }
            }

        }
        return c;
    }
}