class Solution {
    public boolean isBipartite(int[][] graph) {
        int col=-1;
        int []color=new int[graph.length];
        for(int i=0;i<graph.length;i++)
        {
            if(color[i]==0)
            {
                Queue<Integer> mq=new LinkedList<>();
                mq.add(i);
                color[i]=1;
                while(mq.size()>0)
                {
                    int val=mq.remove();
                    for(int x:graph[val])
                    {
                        if(color[x]==0)
                        {
                            color[x]=-color[val];
                            mq.add(x);
                        }
                        else if(color[x]==color[val])
                            return false;
                    }
                }
            }
        }
        return true;
    }
}