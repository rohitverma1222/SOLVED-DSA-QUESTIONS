class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        HashMap<Integer,Integer> hs=new HashMap<>();
        for(int i:nums)
        {
            hs.put(i,hs.getOrDefault(i,0)+1);
        }
        
        perm(0,nums.length,new ArrayList<>(),hs);
        return ans;
    }
    public void perm(int cs,int ts,List<Integer> li,HashMap<Integer,Integer> hs)
    {
        if(cs>=ts)
        {
            ans.add(new ArrayList<>(li));
            return;
        }
        
        for(int i:hs.keySet())
        {
            if(hs.get(i)>0)
            {
                hs.put(i,hs.get(i)-1);
                li.add(i);
                perm(cs+1,ts,li,hs);
                li.remove(li.size()-1);
                hs.put(i,hs.get(i)+1);
            }
            
        }
    }
}