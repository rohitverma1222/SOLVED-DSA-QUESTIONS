class Solution {
    int n;
    int m;
    public int largestIsland(int[][] grid) {
        n=grid.length;
        m=grid[0].length;
        parent=new int[n*m+1];
        rank=new int[n*m+1];
        size=new int[n*m+1];
        for(int i=0;i<rank.length;i++)
        {
            parent[i]=i;
            rank[i]=1;
            size[i]=1;
        }
        int z=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1)
                {
                    handleNbr(grid,i,j);
                }
                else
                {
                    z++;
                }
            }
        }
        int max=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==0)
                {
                    int area=adder(grid,i,j);
                    max=Math.max(area,max);
                }
            }
        }
        if(z==0)
            return n*m;
        return max;
    }

    public int adder(int [][]grid,int i,int j)
    {
        HashSet<Integer> hs=new HashSet<>();
        int ans=0;
        for(int []d:dir)
        {
            int x=i+d[0];
            int y=j+d[1];

            if(x>=0 && y>=0 && x<grid.length && y<grid[0].length && grid[x][y]==1)
            {
                int nb=x*m+y+1;
                int lead=find(nb);
                if(hs.contains(lead)==false)
                {
                    ans+=size[lead];
                    hs.add(lead);
                }
            }
        }
        return ans+1;
    }
    int [][]dir={{-1,0},{1,0},{0,-1},{0,1}};
    public void handleNbr(int [][]grid,int i,int j)
    {
        int ob=i*m+j+1;

        for(int []d:dir)
        {
            int x=i+d[0];
            int y=j+d[1];

            if(x>=0 && y>=0 && x<grid.length && y<grid[0].length && grid[x][y]==1)
            {
                int nb=x*m+y+1;
                union(ob,nb);
            }
        }
    }
    int []parent;
    int []rank;
    int []size;
    public int find(int x)
    {
        if(parent[x]==x)
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
    }
}