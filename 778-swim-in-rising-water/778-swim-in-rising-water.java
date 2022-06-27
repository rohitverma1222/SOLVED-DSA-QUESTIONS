class Solution {
    class pair implements Comparable<pair>{
        int x;
        int y;
        int val;
        pair(int x,int y,int val)
        {
            this.x=x;
            this.y=y;
            this.val=val;
        }
        public int compareTo(pair other)
        {
            return this.val-other.val;
        }
    }
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        PriorityQueue<pair> pq=new PriorityQueue<>();
        pq.add(new pair(0,0,grid[0][0]));
        boolean visited[][]=new boolean[n][m];
        visited[0][0]=true;
        
        int dir[][]={{-1,0},{1,0},{0,1},{0,-1}};
        int max=Integer.MIN_VALUE;
        while(pq.size()>0)
        {
            int size=pq.size();
            while(size-->0)
            {
                pair rem=pq.remove();

                max=Math.max(max,rem.val);
                if(rem.x==grid.length-1 &&rem.y==grid[0].length-1)
                return max;
                
                for(int []d:dir)
                {
                    int ni=rem.x+d[0];
                    int nj=rem.y+d[1];
                    if(ni>=0 && nj>=0 && ni<n && nj<m && !visited[ni][nj])
                    {
                        // System.out.println(ni);
                        pq.add(new pair(ni,nj,grid[ni][nj]));
                        visited[ni][nj]=true;
                    }
                }
            }
        }
        return max;
    }
}