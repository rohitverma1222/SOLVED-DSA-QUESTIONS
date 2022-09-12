class Solution {
    boolean [][]isPal;
    void Palindrome(String s)
    {
        int n=s.length();

        isPal=new boolean[s.length()][s.length()];

        for(int g=0;g<isPal[0].length;g++)
        {
            for(int si=0,ei=g;ei<n;ei++,si++)
            {
                if(g==0)
                {
                    isPal[si][ei]=true;
                }
                else if(g==1)
                {
                    isPal[si][ei]=s.charAt(ei)==s.charAt(si)?true:false;
                }
                else{
                    isPal[si][ei]=s.charAt(ei)==s.charAt(si)?isPal[si+1][ei-1]:false;
                }
            }
        }
    }
    public List<List<String>> partition(String s) {
        Palindrome(s);
        return helper(s.length()-1,s);
    }
    public List<List<String>> helper(int j,String s)
    {
        if(j<0){
            // base case
            List<List<String>> ans=new ArrayList<>();
            List<String> li=new ArrayList<>();
            ans.add(li);
            return ans;
        }


        List<List<String>> mList=new ArrayList<>();

        for(int i=j;i>=0;i--)
        {
            if(isPal[i][j])
            {
                String rest=s.substring(i,j+1);
                List<List<String>> get=helper(i-1,s);
                for(List<String> g:get)
                {
                    g.add(rest);
                    mList.add(g);
                }
            }
        }
        return mList;
    }
}