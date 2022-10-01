class Solution {
    public int minCost(int n, int[] cuts) {
        List<Integer> li=new ArrayList<>();
        for(int i:cuts)
        li.add(i);

        li.add(0);
        li.add(n);
        Collections.sort(li);
        int s=li.size();
        int [][]dp=new int[s][s];
        for(int g=2;g<s;g++)
        {
            for(int si=0,ei=g;ei<s;si++,ei++)
            {
                dp[si][ei]=Integer.MAX_VALUE;
                for(int cut=si+1;cut<ei;cut++)
                {
                    int fact=dp[si][cut]+dp[cut][ei]+li.get(ei)-li.get(si);
                    dp[si][ei]=Math.min(dp[si][ei],fact);
                }
            }
        }
        return dp[0][s-1];
    }
}