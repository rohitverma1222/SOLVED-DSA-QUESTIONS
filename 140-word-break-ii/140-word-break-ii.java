class Solution {
    HashSet<String> hs;
    List<String> li=new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        hs=new HashSet<>();
        for(String str:wordDict)
        {
            hs.add(str);
        }
        
        boolean []dp=new boolean[s.length()];
        for(int i=0;i<dp.length;i++)
        {
            if(hs.contains(s.substring(0,i+1)))
                dp[i]=true;
            else{
                for(int j=0;j<i;j++)
                {
                    if(hs.contains(s.substring(j+1,i+1)))
                    {
                        dp[i]=dp[j] || dp[i];
                    }
                }
            }
        }
        System.out.println(dp[s.length()-1]);
        if(dp[s.length()-1])
        {
            helper(dp,s,0,"");
        }
        return li;
    }
    public void helper(boolean []dp,String s,int i,String ssf)
    {
        if(i>=s.length())
        {
            // System.out.println(ssf);
            li.add(ssf.substring(0,ssf.length()-1));
            return;
        }

        for(int idx=i;idx<s.length();idx++)
        {
            if(dp[idx] && hs.contains(s.substring(i,idx+1)))
                helper(dp,s,idx+1,ssf+s.substring(i,idx+1)+" ");
        }
    }
}