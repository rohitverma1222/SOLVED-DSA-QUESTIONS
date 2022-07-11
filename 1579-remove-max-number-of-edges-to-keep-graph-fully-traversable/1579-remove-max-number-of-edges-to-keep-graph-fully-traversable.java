class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int []parent=new int[n+1];
        int []rank=new int[n+1];
        for(int i=0;i<n+1;i++)
        {
        	parent[i]=i;
        	rank[i]=0;
        }

        for(int []e:edges)
        {
        	if(e[0]==3)
        	{
        		union(e[1],e[2],rank,parent);
        	}
        }
       int [] p1=parent.clone();
        int []r1=rank.clone();

        for(int []e:edges)  //alice
        {
        	if(e[0]==1)
        	{
        		union(e[1],e[2],r1,p1);
        	}
        }
        for(int []e:edges)
        {
        	if(e[0]==2)
        	{
        		union(e[1],e[2],rank,parent);
        	}
        }
        int a=0;
        int b=0;
        for(int i=0;i<n+1;i++)
        {
            if(parent[i]==i)
                a++;
            
            if(p1[i]==i)
                b++;
        }
        if(a>2 || b>2)
            return -1;
        return c;
    }
    int c=0;
    public int find(int x,int []parent)
    {
    	if(x==parent[x])
    		return x;
    	int st=find(parent[x],parent);
    	parent[x]=st;
    	return st;
    }

    public void union(int u,int v,int rank[],int parent[])
    {
    	int leadU=find(u,parent);
    	int leadV=find(v,parent);

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
    		c++;
    	}
    }
}