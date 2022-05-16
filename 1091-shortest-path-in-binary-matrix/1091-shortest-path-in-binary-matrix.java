class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid==null || grid.length==0 || grid[0].length==0)
            return -1;
        int ans=0;
        int row=grid.length;
        int col=grid[0].length;
        
        if(grid[0][0]==1 || grid[row-1][col-1]==1)
            return -1;
        

        int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        boolean visited[][]=new boolean[row][col];
        Queue<int[]> mq=new LinkedList<>();
        mq.add(new int[]{0,0});
            visited[0][0]=true;
        while(mq.size()!=0)
        {
            int size=mq.size();
            ans++;
            
            for(int i=0;i<size;i++)
            {
                int []get=mq.remove();
                
                if(get[0]==row-1 && get[1]==col-1)
                    return ans;
                
                for(int[] d:dirs)
                {
                    
                    int x=get[0]+d[0];
                    int y=get[1]+d[1];
                    
                    if(x<0 ||y<0 || x>=row || y>=col || visited[x][y] || grid[x][y]==1)
                        continue;
                    
                    visited[x][y]=true;
                    mq.add(new int[]{x,y});
                }
            }
        }
        return -1;
    }
}