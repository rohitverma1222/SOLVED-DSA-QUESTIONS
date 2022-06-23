class Solution {
    int parent[];
    int rank[];
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        // int m=edges[0].length;
        parent=new int[n+1];
        rank=new int[n+1];
        for(int i=1;i<n;i++)
        {
            parent[i]=i;
            rank[i]=0;
        }
        for(int i=0;i<n;i++)
        {
            int ans[]=union(edges[i][0],edges[i][1]);
            if(ans.length>0)
            return ans;
        }
        return new int[0];
    }
    public int find(int x)
    {
        if(parent[x]==x)
            return x;
        int st=find(parent[x]);
        parent[x]=st;
        return st;
    }
    
    public int [] union(int u,int v)
    {
        int leadU=find(u);
        int leadV=find(v);
        
        if(leadU!=leadV)
        {
            int rankU=rank[leadU];
            int rankV=rank[leadV];
            
            if(rankU<rankV)
            {
                parent[leadU]=leadV;
            }
            else if(rankV<rankU)
            {
                parent[leadV]=leadU;
            }
            else
            {
                parent[leadU]=leadV;
                rank[leadV]++;
            }
            return new int[0];
        }
        else
        {
            return new int[]{u,v};
        }
    }
}