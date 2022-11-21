class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int r=maze.length;
        int c=maze[0].length;

        int [][]dir={{-1,0},{1,0},{0,-1},{0,1}};
        LinkedList<int[]> mq=new LinkedList<>();
        boolean visited[][]=new boolean[r][c];
        mq.add(new int[]{entrance[0],entrance[1]});
        visited[entrance[0]][entrance[1]]=true;
        int dis=0;
        while(mq.size()!=0)
        {
            int size=mq.size();
            dis++;
            
            for(int i=0;i<size;i++)
            {

                int []ans=mq.remove();


                for(int d[]:dir)
                {
                    int ni=d[0]+ans[0];
                    int nj=d[1]+ans[1];

                    if(ni<0 || nj<0 || ni>=r || nj>=c)
                        continue;
                    if(visited[ni][nj] || maze[ni][nj]=='+')
                        continue;
                    if(ni==0 || ni==r-1 || nj==0 || nj==c-1)
                        return dis;

                    mq.add(new int[]{ni,nj});
                    visited[ni][nj]=true;
                }
            }
            
        }
        return -1;
    }
}