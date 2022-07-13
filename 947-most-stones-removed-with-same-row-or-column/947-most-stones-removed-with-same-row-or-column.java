class Solution {
    public int removeStones(int[][] stones) {
        int n=stones.length;
        parent=new int[n];
        rank=new int[n];

        for(int i=0;i<n;i++)
        {
            parent[i]=i;
            rank[i]=0;
        }

        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                int []stone=stones[i];
                int []ss=stones[j];
                if(stone[0]==ss[0] || stone[1]==ss[1])
                {
                    union(i,j);
                }
            }
        }
        int c=0;
        for(int i=0;i<n;i++)
        {
            if(parent[i]==i)
                c++;
        }
        return n-c;
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
            {
                parent[leadU]=leadV;
            }
            else if(rank[leadV]<rank[leadU])
            {
                parent[leadV]=leadU;
            }
            else{
                parent[leadU]=leadV;
                rank[leadV]++;
            }
        }
    }
}