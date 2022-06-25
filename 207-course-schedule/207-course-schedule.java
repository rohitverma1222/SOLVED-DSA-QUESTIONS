class Solution {
    public boolean canFinish(int nums, int[][] pre) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<nums;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<pre.length;i++)
        {
            int v1=pre[i][0];
            int v2=pre[i][1];
            
            adj.get(v1).add(v2);
        }
        return helper(nums,adj);
    }
    public boolean helper(int v,List<List<Integer>> adj)
    {
        int []inde=new int[v];

        for(int i=0;i<v;i++)
        {
            for(int val:adj.get(i))
                inde[val]++;
        }
        Queue<Integer> mq=new LinkedList<>();
        for(int i=0;i<v;i++)
        {
            if(inde[i]==0)
                mq.add(i);
        }
        int idx=0;
        while(mq.size()>0)
        {
            int val=mq.remove();
            idx++;

            for(int vv:adj.get(val))
            {
                inde[vv]--;
                if(inde[vv]==0)
                    mq.add(vv);
            }
        }
        if(idx!=v)
            return false;
        return true;
    }
}