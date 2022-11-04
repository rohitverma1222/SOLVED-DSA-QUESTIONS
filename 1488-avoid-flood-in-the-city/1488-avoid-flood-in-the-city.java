class Solution {
    public int[] avoidFlood(int[] rains) {
        HashMap<Integer,Integer> hs=new HashMap<>();
        int []ans=new int[rains.length];
        TreeSet<Integer> tr=new TreeSet<>();
        // ans[0]=-1;
        for(int i=0;i<rains.length;i++)
        {
            if(rains[i]==0)
            {
                tr.add(i);
            }
            else{
                
                if(hs.containsKey(rains[i]))
                {
                    int val=hs.get(rains[i]);
                    
                    
                    Integer idx=tr.ceiling(val);
                    if(idx==null)
                        return new int[0];
                    tr.remove(idx);
                    ans[idx]=rains[i];
                }
                hs.put(rains[i],i);
                ans[i]=-1;
                
            }
        }
        for(int i=0;i<ans.length;i++)
        {
            if(ans[i]==0)
                ans[i]=1;
        }
        return ans;
    }
}