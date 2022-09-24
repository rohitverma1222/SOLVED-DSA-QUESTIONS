class Solution {
    class pair{
        int i=0;
        int j=0;
        int t=0;
        pair(int i,int j,int t)
        {
            this.i=i;
            this.j=j;
            this.t=t;
        }
    }
    int n;
    int m;
    public int orangesRotting(int[][] grid) {
        n=grid.length;
        m=grid[0].length;
        ArrayDeque<pair> mq=new ArrayDeque<>();
        boolean visited[][]=new boolean[n][m];
        int c=0;
        int t=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==2)
                {
                    mq.add(new pair(i,j,0));
                    t++;
                }
                else if(grid[i][j]==1){
                    c++;
                }
            }
        }
        if(c==0)
            return 0;
        int [][]dir={{1,0},{-1,0},{0,1},{0,-1}};
        int time=-1;
        while (mq.size()!=0) {
            int size=mq.size();
            time++;
            while(size-->0)
            {
                pair rem=mq.removeFirst();
                
                for(int d[]:dir)
                {
                    int ni=rem.i+d[0];
                    int nj=rem.j+d[1];
                    if(ni>=0 && nj>=0 && ni<n && nj<m && grid[ni][nj]==1 )
                    {
                        mq.add(new pair(ni,nj,rem.t+1));
                        c--;
                        grid[ni][nj]=2;
                    }
                }
            }
        }
        if(c!=0)
            return -1;
        return time;
    }
}