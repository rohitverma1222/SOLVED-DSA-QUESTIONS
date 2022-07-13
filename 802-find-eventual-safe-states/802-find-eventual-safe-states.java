class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> li=new ArrayList<>();
        int []vis=new int[graph.length];
        for(int i=0;i<vis.length;i++)
        {
            vis[i]=dfs(graph,i,vis)==true ? 2 :1;
            if(vis[i]==2)
                li.add(i);
                
        }
        return li;
    }
    public boolean dfs(int [][]graph,int i,int []vis)
    {
        if(vis[i]==1)
            return false;
        else if(vis[i]==2)
            return true;
        
        vis[i]=1;
        for(int val:graph[i])
        {
            boolean ans=dfs(graph,val,vis);
            if(ans==false)
                return false;
        }
        vis[i]=2;
        return true;
    }
        
}