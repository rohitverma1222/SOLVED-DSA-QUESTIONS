class Solution {
    public boolean canCross(int[] stones) {
        if(stones[1]-stones[0]>1)
            return false;
        HashMap<Integer,HashSet<Integer>> hs=new HashMap<>();
        for(int i:stones)
        {
            hs.put(i,new HashSet<>());
        }

        hs.get(0).add(1);

        for(int i=0;i<stones.length;i++)
        {
            HashSet<Integer> jumps=hs.get(stones[i]);
            for(int j:jumps)
            {
                int val=stones[i]+j;

                if(val==stones[stones.length-1])
                    return true;
                if(hs.containsKey(val)==true)
                {
                    if(j-1>0)
                        hs.get(val).add(j-1);

                    hs.get(val).add(j);
                    hs.get(val).add(j+1);
                }
            }
        }
        return false;
    }
}