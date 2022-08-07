class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        HashMap<Integer,Long> hs=new HashMap<>();

        long res=0;

        for(int a:tasks)
        {
            if(hs.containsKey(a))
            {
                hs.put(a,res=Math.max(res,hs.get(a)+space)+1);
            }
            else{
                hs.put(a,++res);
            }
        }

        return res;
    }
}