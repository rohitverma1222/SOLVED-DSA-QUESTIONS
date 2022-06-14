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
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int time=-1;
        int count=0;
        int r=0;
        ArrayDeque<pair> mq=new ArrayDeque<>();
        boolean visited[][]=new boolean[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==2)
                {
                    mq.add(new pair(i,j));
                    // r++;
                }
               else if(grid[i][j]==1)
                    count++;
            }
        }
        if(count==0)
            return 0;
                        // System.out.println(count);
        count+=r;
        int [][]dir={{-1,0},{1,0},{0,1},{0,-1}};
        while(mq.size()>0)
        {
            int size=mq.size();
            time++;
            while(size-->0)
            {
                pair rem=mq.remove();
                
//                 if(visited[rem.x][rem.y]==true)
//                     continue;
//                 visited[rem.x][rem.y]=true;
                
                for(int d[]:dir)
                {
                    int ni=rem.x+d[0];
                    int nj=rem.y+d[1];
                    
                    if(ni>=0 && nj>=0 && ni<n && nj<m && grid[ni][nj]==1)
                    {
                        mq.add(new pair(ni,nj));
                        grid[ni][nj]=0;
                        count--;
                    }
                }
            }
            
        }
                        System.out.println(count);
        
        if(count!=0)
            return -1;
        return time;
    }
}