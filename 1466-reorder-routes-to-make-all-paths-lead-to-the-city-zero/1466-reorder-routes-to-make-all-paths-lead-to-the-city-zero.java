class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> li=new ArrayList<>();
        HashSet<String> hs=new HashSet<>();
        for(int i=0;i<n;i++)
        {
            li.add(new ArrayList<>());
        }

        for(int []c:connections)
        {
            li.get(c[0]).add(c[1]);
            li.get(c[1]).add(c[0]);

            hs.add(c[0]+"->"+c[1]);
        }

        boolean []visited=new boolean[n];
        Queue<Integer> mq=new LinkedList<>();
        mq.add(0);
        int c=0;
        while(mq.size()>0)
        {
            int s=mq.size();
            for(int i=0;i<s;i++)
            {
                int rem=mq.remove();

                visited[rem]=true;

                for(int v:li.get(rem))
                {
                    if(visited[v]==false)
                    {
                        if(hs.contains(rem+"->"+v))
                            c++;
                        mq.add(v);
                    }
                }
            }
        }
        return c;
        
    }

}