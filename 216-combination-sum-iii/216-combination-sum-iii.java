class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        for(int i=1;i<=9;i++)
        {
            List<Integer> li=new ArrayList<>();
            li.add(i);
        helper(i,1,li,i,n,k);
        }
        return ans;
    }
    public void helper(int vidx,int ssf,List<Integer> li,int sum,int ts,int k)
    {
        if(sum==ts)
        {
            if(ssf==k)
            {
                // System.out.println(li);
                ans.add(new ArrayList<>(li));
            }
            return;
        }
        
        for(int i=vidx+1;i<=9;i++)
        {
            li.add(i);
            sum+=i;
            helper(i,ssf+1,li,sum,ts,k);
            sum-=i;
            li.remove(li.size()-1);
        }
    }
}