class Solution {
    class pair{
        int x;
        int y;
        int maxdiff;
        pair(int x,int y,int maxdiff)
        {
            this.x=x;
            this.y=y;
            this.maxdiff=maxdiff;
        }
    }
    
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->{
            return a.maxdiff-b.maxdiff;
        });
        int ret=Integer.MAX_VALUE;

        int n=heights.length;
        int m=heights[0].length;
        boolean [][]visited=new boolean[n][m];
        pq.add(new pair(0,0,0));
        // visited[0][0]=true;

        int [][]dir={{1,0},{-1,0},{0,-1},{0,1}};
        while(pq.size()>0)
        {
            int size=pq.size();
            while(size-->0)
            {
                pair rem=pq.remove();
                if(visited[rem.x][rem.y]==true)
                    continue;
                visited[rem.x][rem.y]=true;
                if(rem.x>=n-1 && rem.y>=m-1)
                {
                    ret=Math.min(ret,rem.maxdiff);
                }
                for(int []d:dir)
                {
                    int ni=rem.x+d[0];
                    int nj=rem.y+d[1];
                    if(ni>=0 && nj>=0 && ni<n && nj<m && visited[ni][nj]==false)
                    {
                        pq.add(new pair(ni,nj,Math.max(rem.maxdiff,Math.abs(heights[rem.x][rem.y]-heights[ni][nj]))));
                    }
                }
            }
        }

        return ret;

    }
    
}