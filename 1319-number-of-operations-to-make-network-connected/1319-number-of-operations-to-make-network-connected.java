class Solution {
    int parent[];
    int rank[];
    public int makeConnected(int n, int[][] connections) {
        
        parent=new int[n];
        rank=new int[n];

        for(int i=0;i<n;i++)
        {
            parent[i]=i;
            rank[i]=0;
        }
        // int cy=0;
        for(int []c:connections)
        {
            unionhelper(c[0],c[1]);
        }
        int c=0;
        for(int i=0;i<n;i++)
        {
            if(parent[i]==i)
                c++;
        }
        System.out.println(c+" "+cables);
        if(c-1>cables)
            return -1;
        if(cables>=c)
            return c-1;
        return cables;
    }
    public int find(int x)
    {
        if(parent[x]==x)
            return x;
        int st=find(parent[x]);
        parent[x]=st;
        return st;
    }
    int cables=0;

    public void unionhelper(int x,int y)
    {
        int leadU=find(x);
        int leadV=find(y);
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
        else{
            cables++;
        }
    }
}