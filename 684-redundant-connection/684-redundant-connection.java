class Solution {
    int []rank;
    int []parent;
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        parent=new int[n+1];
        rank=new int[1+n];
        for(int i=0;i<n;i++)
        {
            parent[i]=i;
            rank[i]=1;
        }
        for(int []i:edges)
        {
            int u=i[0];
            int v=i[1];
            int ans[]=union(u,v);
            if(ans.length>0)
                return ans;
        }
        return new int[0];
    }
    public int find(int x)
    {
        if(parent[x]==x)
            return parent[x];
        int st=find(parent[x]);
        parent[x]=st;
        return st;
    }
    public int[] union(int u,int v)
    {
        int leadu=find(u);
        int leadv=find(v);
        if(leadu!=leadv)
        {
            int ranku=find(leadu);
            int rankv=find(leadv);

            if(ranku<rankv)
            {
                parent[leadu]=leadv;
            }else if(rankv<ranku)
            {
                parent[leadv]=ranku;
            }
            else{
                parent[leadu]=leadv;
                rank[leadv]++;
            }
            return new int[0];
        }
        else
            return new int[]{u,v};
        
    }
}