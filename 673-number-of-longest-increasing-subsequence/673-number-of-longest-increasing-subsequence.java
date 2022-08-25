class Solution {
    public int findNumberOfLIS(int[] nums) {
        if(nums.length==1)
            return 1;
        int n=nums.length;
        int dp[]=new int[n];
        int c[]=new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(c,1);
        int max=Integer.MIN_VALUE;
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(nums[i]>nums[j])
                {
                    if(dp[j]+1>dp[i])
                    {
                        dp[i]=dp[j]+1;
                        c[i]=c[j];
                    }
                    else if(dp[j]+1==dp[i])
                    {
                        c[i]+=c[j];
                    }
                }
            }
            max=Math.max(max,dp[i]);
        }

        int cc=0;
        for(int i=0;i<n;i++)
        {
            if(dp[i]==max)
            {
                cc+=c[i];
            }
        }
        return cc;
    }
}