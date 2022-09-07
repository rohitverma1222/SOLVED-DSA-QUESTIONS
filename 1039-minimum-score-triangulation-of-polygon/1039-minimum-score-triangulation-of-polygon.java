class Solution {
    public int minScoreTriangulation(int[] arr) {
      int [][]dp=new int[arr.length][arr.length];
        for(int i[]:dp)
        Arrays.fill(i,-1);
        return MCM(arr,0,arr.length-1,dp);
        // return dp[0][arr.length-1];
    }
    public static int MCM(int []arr,int si,int ei,int [][]dp)
    {
        if(ei-si==1)
            return dp[si][ei]=0;

        if(dp[si][ei]!=-1)
        {
            return dp[si][ei];
        }
        int min=(int)1e9;
        for(int i=si+1;i<ei;i++)
        {
            int left=MCM(arr,si,i,dp);
            int right=MCM(arr,i,ei,dp);
            min=Math.min(min,left+arr[si]*arr[i]*arr[ei]+right);
        }
        return dp[si][ei]=min;
    }
}