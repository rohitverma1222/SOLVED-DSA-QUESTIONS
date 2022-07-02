class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n=edges.length;
        parent=new int[n+1];
        rank=new int[n+1];
        
        for(int i=0;i<n+1;i++)
        {
            parent[i]=i;
            rank[i]=0;
        }
        int []in=new int[n+1];
        Arrays.fill(in,-1);
        int bl1=-1;
        int bl2=-1;
        for(int i=0;i<n;i++)
        {
            int v=edges[i][1];
            if(in[v]==-1)
            {
                in[v]=i;
            }
            else
            {
                bl1=i;
                bl2=in[v];
                    break;
            }
        }
        
        for(int i=0;i<edges.length;i++)
        {
            if(i==bl1)
                continue;
            int u=edges[i][0];
            int v=edges[i][1];
            
            boolean ans=union(u,v);
            if(ans)
            {
                if(bl1==-1)
                    return edges[i];
                else return edges[bl2];
            }
        }
        return edges[bl1];
    }
    int []parent;
    int []rank;
    public int find(int x)
    {
        if(parent[x]==x)
            return x;
        int st=find(parent[x]);
        parent[x]=st;
        return st;
    }
    
    public boolean union(int u,int v)
    {
        int lu=find(u);
        int lv=find(v);
        
        if(lu!=lv)
        {
            if(rank[lu]<rank[lv])
            {
                parent[lu]=lv;
            }
            else if(rank[lu]>rank[lv])
            {
                parent[lv]=lu;
            }
            else{
                parent[lv]=lu;
                rank[lu]++;
            }
            return false;
        }
        else
            return true;
    }
}