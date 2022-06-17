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
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        Queue<pair> mq=new LinkedList<>();
        mq.add(new pair(row,col));
        ArrayList<pair> ar=new ArrayList<>();
        boolean []visited[]=new boolean[grid.length][grid[0].length];
        // if(isBorder(grid,row,col))
        //     ar.add(new pair(row,col));
        
        int []dir[]={{-1,0},{1,0},{0,-1},{0,1}};

        while(mq.size()>0)
        {
            int size=mq.size();
            while(size-->0)
            {
                pair rem=mq.remove();
                if(visited[rem.x][rem.y])
                    continue;

                visited[rem.x][rem.y]=true;
                if(isBorder(grid,rem.x,rem.y))
                    ar.add(rem);

                for(int []d:dir)
                {
                    int ni=rem.x+d[0];
                    int nj=rem.y+d[1];
                    if(ni>=0 && nj>=0 && ni<grid.length && nj<grid[0].length && visited[ni][nj]==false && grid[row][col]==grid[ni][nj])
                    {
                        
                        // System.out.println(grid[rem.x][rem.y]);
                        mq.add(new pair(ni,nj));
                    }
                }
            }
        }

        for(pair rem:ar)
        {
            grid[rem.x][rem.y]=color;
        }
        return grid;
    }
    public boolean isBorder(int [][]grid,int i,int j)
    {
        if(i==0)
            return true;
        else if(j==0)
            return true;
        else if(i>=grid.length-1)
            return true;
        else if(j>=grid[0].length-1)
            return true;
        else{
            if(grid[i-1][j]!=grid[i][j])
                return true;
            else if(grid[i+1][j]!=grid[i][j])
                return true;
            else if(grid[i][j-1]!=grid[i][j])
                return true;
            else if(grid[i][j+1]!=grid[i][j])
                return true;
            else
                return false;
        }
    }
}