class Solution {
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        parent=new int[n+1];
        rank=new int[n+1];
        for(int i=0;i<parent.length;i++)
        {
            parent[i]=i;
            rank[i]=0;
        }

        for(int i=1;i<=n;i++)
        {
            for(int div=threshold+1;div*i<=n;div++)
            {
                union(div,div*i);
            }
        }

        // boolean ans[]=new boolean[queries.length];
        List<Boolean> li=new ArrayList<>();
        int i=0;
        for(int []q:queries)
        {
            int u=q[0];
            int v=q[1];
            if(find(u)!=find(v))
            {
                li.add(false);
            }
            else{
                // ans[i]=true;
                li.add(true);
            }
            i++;
        }
        return li;
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

    public void union(int u,int v)
    {
        int leadU=find(u);
        int leadV=find(v);

        if(leadU!=leadV)
        {
            if(rank[leadU]<rank[leadV])
                parent[leadU]=leadV;
            else if(rank[leadV]<rank[leadU])
                parent[leadV]=leadU;
            else{
                parent[leadU]=leadV;
                rank[leadV]++;
            }
        }
    }
}