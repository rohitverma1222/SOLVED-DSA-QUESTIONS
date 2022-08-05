class Solution {
    public int combinationSum4(int[] nums, int target) {
        int dp[]=new int[target+1];
        dp[0]=1;
        for(int i=1;i<dp.length;i++)
        {
            int s=0;
            for(int j:nums)
            {

                if(i-j>=0)
                {
                    s+=dp[i-j];
                }
            }
            System.out.println(s);
            dp[i]=s;
        }
        return dp[target];
    }
}