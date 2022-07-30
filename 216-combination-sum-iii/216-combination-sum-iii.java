class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        for(int i=1;i<=9;i++)
        {
            List<Integer> l=new ArrayList<>();
            l.add(i);
            helper(i,i,l,1,k,n);
        }
        return ans;
    }
    public void helper(int idx,int sum,List<Integer> li,int ssf,int k,int ts)
    {
        if(sum==ts)
        {
            if(ssf==k)
            {
                ans.add(new ArrayList<>(li));
            }
            return;
        }
        
        for(int i=idx+1;i<=9;i++)
        {
            sum+=i;
            li.add(i);
            helper(i,sum,li,ssf+1,k,ts);
            sum-=i;
            li.remove(li.size()-1);
        }
    }
}