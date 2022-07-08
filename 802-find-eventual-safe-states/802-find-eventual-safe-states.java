class Solution {
    int []vis;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        vis=new int[graph.length];
        List<Integer> li=new ArrayList<>();
        for(int i=0;i<graph.length;i++)
        {
        	// int val=dfs();
        	if(vis[i]==2 || dfs(graph,i))
        		li.add(i);
        }
        return li;
    }
    public boolean dfs(int [][]graph,int src)
    {
    	if(vis[src]==1)
    		return false;
    	else if(vis[src]==2)
    		return true;
    	vis[src]=1;
    	for(int i:graph[src])
    	{
    		boolean ans=dfs(graph,i);
    		if(ans==false)
    			return false;
    	}
    	vis[src]=2;
    	return true;
    }
}