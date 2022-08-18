class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer,Integer> hs1=new HashMap<>();
        HashMap<Integer,Integer> hs2=new HashMap<>();
        
        
        for(int i[]:matches)
        {
            hs1.put(i[0],hs1.getOrDefault(i[0],0)+1);
        }
        
        for(int i[]:matches)
        {
            hs2.put(i[1],hs2.getOrDefault(i[1],0)+1);
        }
        
        List<Integer> li1=new ArrayList<>();
        List<Integer> li2=new ArrayList<>();

        for(int i:hs1.keySet())
        {
            if(!hs2.containsKey(i))
            {
                li1.add(i);
            }
            else
            {
                if(hs2.get(i)==1)
                {
                    li2.add(i);
                }
            }
        }
        
        for(int i:hs2.keySet())
        {
            if(hs2.get(i)==1 && hs1.containsKey(i)==false)
            {
                li2.add(i);
            }
        }
        
       Collections.sort(li1);
       Collections.sort(li2);
        List<List<Integer>> ans=new ArrayList<>();
    ans.add(new ArrayList<>(li1));
        ans.add(new ArrayList<>(li2));
        return ans;
    }
}