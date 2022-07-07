class Solution {
	HashMap<String,PriorityQueue<String>> adj;
    public List<String> findItinerary(List<List<String>> tickets) {
        adj=new HashMap<>();

        for(List<String> li:tickets)
        {
        	String s1=li.get(0);
        	String s2=li.get(1);

        	if(adj.containsKey(s1))
        	{
        		adj.get(s1).add(s2);
        	}
        	else{
        		adj.put(s1,new PriorityQueue<>());
        		adj.get(s1).add(s2);
        		
        	}
        }
        LinkedList<String> li=new LinkedList<>();
        dfs("JFK",li);
        return li;

    }
    public void dfs(String str,LinkedList<String> li)
    {
    	if(adj.containsKey(str)==false || adj.get(str).size()==0)
    	{
    		li.addFirst(str);
    		return;
    	}

    	while(adj.get(str).size()>0)
    	{
    		String ss=adj.get(str).remove();
    		dfs(ss,li);
    	}
        
    	li.addFirst(str);
    }
}