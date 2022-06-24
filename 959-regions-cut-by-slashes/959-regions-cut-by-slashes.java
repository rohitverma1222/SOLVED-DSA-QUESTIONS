class Solution {
    public int regionsBySlashes(String[] grid) {
        int dots=grid.length+1;

        parent=new int[dots*dots];
        rank=new int[dots*dots];
        for(int i=0;i<dots*dots;i++)
        {
            parent[i]=i;
            rank[i]=0;
        }
        count=1;
        //Added boundary
        for(int i=0;i<dots;i++)
        {
            for(int j=0;j<dots;j++)
            {
                if(i==0 || j==0 || i==dots-1 || j==dots-1)
                {
                    int cellno=i*dots+j;
                    if(cellno!=0)
                    union(0,cellno);
                }
            }
        }

        for(int i=0;i<grid.length;i++)
        {
            char []ch=grid[i].toCharArray();
            for(int j=0;j<ch.length;j++)
            {
                if(ch[j]=='/')
                {
                    int cellno1=i*dots+j+1;
                    int cellno2=(i+1)*dots+j;
                    union(cellno1,cellno2);
                }
                else if(ch[j]=='\\')
                {
                    int cellno1=i*dots+j;
                    int cellno2=(i+1)*dots+(j+1);
                    union(cellno1,cellno2);
                }
            }
        }
        return count;
    }
    int count;
    int parent[];
    int rank[];
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
        int slu=find(u);
        int slv=find(v);
        if(slu!=slv)
        {
            int rankU=rank[slu];
            int rankV=rank[slv];

            if(rankU<rankV)
            {
                parent[slu]=slv;
            }
            else if(rankV<rankU)
            {
                parent[slv]=slu;
            }
            else{
                parent[slu]=slv;
                rank[slv]++;
            }
        }
        else{
            count++;
        }

    }
}