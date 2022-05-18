class Solution {
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer> []graph=new ArrayList[n];
        for(int i=0;i<n;i++)
        {
            graph[i]=new ArrayList<>();
        }
        
        for(List<Integer> li:connections)
        {
            graph[li.get(0)].add(li.get(1));
            graph[li.get(1)].add(li.get(0));
        }
        
        HashSet<List<Integer>> connectionSet=new HashSet<>(connections);
        int []rank=new int[n];
        Arrays.fill(rank,-2);
        dfs(graph,0,0,rank,connectionSet);
        return new ArrayList<>(connectionSet);
        
    }
    public int dfs(List<Integer> []graph,int node,int depth,int[] rank,HashSet<List<Integer>> connectionsSet)
    {
       if (rank[node]>=0){
            return rank[node]; // already visited node. return its rank
        }
        rank[node] = depth;
        int minDepthFound = depth; // can be Integer.MAX_VALUE also.
        for(Integer nbr: graph[node]){
            if (rank[nbr] == depth-1){ // ignore parent
                continue;
            }
            int minDepth = dfs(graph, nbr, depth+1, rank, connectionsSet);
            minDepthFound = Math.min(minDepthFound, minDepth);
            
             if (minDepth <= depth){
                // to avoid the sorting just try to remove both combinations. of (x,y) and (y,x)
                connectionsSet.remove(Arrays.asList(node, nbr)); 
                connectionsSet.remove(Arrays.asList(nbr, node)); 
            }
        }
        return minDepthFound;
    }
}