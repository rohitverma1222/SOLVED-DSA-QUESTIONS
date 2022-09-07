class Solution {
    public int minScoreTriangulation(int[] arr) {
    int [][]dp=new int[arr.length][arr.length];
        for(int g=0;g<arr.length;g++)
        {
            for(int si=0,ei=g;ei<arr.length;si++,ei++)
            {
                if(ei-si==1)
                {
                    dp[si][ei]=0;
                    continue;
                }
                int min=(int)1e9;
                for(int i=si+1;i<ei;i++)
                {
                    int left=dp[si][i];
                    int right=dp[i][ei];
                    min=Math.min(min,left+arr[si]*arr[i]*arr[ei]+right);
                }
                dp[si][ei]=min;
            }
        }
        return dp[0][arr.length-1];
    }
}