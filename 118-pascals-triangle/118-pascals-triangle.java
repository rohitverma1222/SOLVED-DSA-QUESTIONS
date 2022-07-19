class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans=new ArrayList<>();
        if(numRows==0)
            return ans;
        List<Integer> li=new ArrayList<>();
        li.add(1);
        ans.add(li);
        if(numRows==1)
            return ans;
        int c=0;
        for(int i=0;i<numRows-1;i++)
        {
            List<Integer> ret=new ArrayList<>();
            ret.add(1);
            for(c=0;c<ans.get(i).size()-1;c++)
            {
                
                int f=ans.get(i).get(c);
                int s=ans.get(i).get(c+1);

                ret.add(f+s);
            }
            ret.add(1);

            ans.add(ret);
        }
        return ans;
    }
}