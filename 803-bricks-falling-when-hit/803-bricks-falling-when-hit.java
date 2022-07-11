class Solution {
    int n=0;
    int m=0;
    public int[] hitBricks(int[][] grid, int[][] hits) {
        n=grid.length;
        m=grid[0].length;
        size=new int[n*m+1];
        parent=new int[n*m+1];
        rank=new int[n*m+1];

        for(int i=0;i<rank.length;i++)
        {
            parent[i]=i;
            size[i]=1;
            rank[i]=0;
        }

        for(int []h:hits)
        {
            if(grid[h[0]][h[1]]==1)
                grid[h[0]][h[1]]=2;
        }

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1)
                handleUnion(grid,i,j);
            }
        }
        int res[]=new int[hits.length];

        for(int h=hits.length-1;h>=0;h--)
        {
            int i=hits[h][0];
            int j=hits[h][1];

                if(grid[i][j]==2)
                {
                    int oldbrick=size[find(0)];
                    grid[i][j]=1;

                    handleUnion(grid,i,j);
                    int newbrick=size[find(0)];
                    if(newbrick==oldbrick)
                    {
                        
                    }
                    else
                        res[h]=newbrick-oldbrick-1;
                }
            }
        
        return res;
    }
    int [][]dir={{1,0},{-1,0},{0,-1},{0,1}};
    public void handleUnion(int [][]grid,int i,int j)
    {
        int boxNo=i*m+j+1;

        for(int []d:dir)
        {
            int ni=i+d[0];
            int nj=j+d[1];

            if(ni>=0 && nj>=0 && ni<grid.length && nj< grid[0].length && grid[ni][nj]==1)
            {
                int newbox=ni * m + nj+1;
                union(newbox,boxNo);
            }

        }
        if(i==0)
        {
            union(0,boxNo);
        }

    }
    int size[];
    int parent[];
    int rank[];
    public int find(int x)
    {
        if(x==parent[x])
            return x;
        int st=find(parent[x]);

        parent[x]=st;
        return st;
    }

    public void union(int u,int v)
    {
        int leadU=find(u);
        int leadV=find(v);

        if(leadU!=leadV)
        {
            if(rank[leadU]<rank[leadV])
            {
                parent[leadU]=leadV;
                size[leadV]+=size[leadU];
            }
            else if(rank[leadV]<rank[leadU])
            {
                parent[leadV]=leadU;
                size[leadU]+=size[leadV];
            }
            else{
                parent[leadU]=leadV;
                rank[leadV]++;
                size[leadV]+=size[leadU];
            }
        }
        else{
            return;
        }
    }
}