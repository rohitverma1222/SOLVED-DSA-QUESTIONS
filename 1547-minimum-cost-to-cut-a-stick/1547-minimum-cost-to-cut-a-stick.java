class Solution {
    public int minCost(int n, int[] cuts) {
        List<Integer> li=new ArrayList<>();
        for(int i:cuts)
        li.add(i);

        li.add(0);
        li.add(n);
        Collections.sort(li);
        // int s=li.size();
        // int [][]dp=new int[s][s];
        // for(int g=2;g<s;g++)
        // {
        //     for(int si=0,ei=g;ei<s;si++,ei++)
        //     {
        //         dp[si][ei]=Integer.MAX_VALUE;
        //         for(int cut=si+1;cut<ei;cut++)
        //         {
        //             int fact=dp[si][cut]+dp[cut][ei]+li.get(ei)-li.get(si);
        //             dp[si][ei]=Math.min(dp[si][ei],fact);
        //         }
        //     }
        // }
        return helper(1,li.size()-2,li,new int[li.size()][li.size()]);
    }
    public int helper(int si,int ei,List<Integer> li,int [][]dp)
    {
        if(si>ei)
            return 0;
        else if(dp[si][ei]!=0)
            return dp[si][ei];
                int val=Integer.MAX_VALUE;
                for(int cut=si;cut<=ei;cut++)
                {
                    int fact=helper(si,cut-1,li,dp);
                        int s=helper(cut+1,ei,li,dp);
                        int v=li.get(ei+1)-li.get(si-1);
                    val=Math.min(val,fact+s+v);
                }
        return dp[si][ei]=val;
    }
}