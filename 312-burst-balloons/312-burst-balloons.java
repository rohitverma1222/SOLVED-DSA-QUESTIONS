class Solution {
    public int maxCoins(int[] nums) {
        int []dp[]=new int[nums.length][nums.length];

    //     return burst(nums,0,nums.length-1,dp);
    // }
    // public int burst(int []arr,int si,int ei,int [][]dp)
    // {
    //     // if(dp[si][ei]!=0)
    //     //     return dp[si][ei];
        
        for(int g=0;g<dp.length;g++)
        {
            for(int si=0,ei=g;ei<dp.length;ei++,si++)
            {
                int left=si==0 ? 1: nums[si-1];
                int right=ei==nums.length-1 ?1:nums[ei+1];

                int max=0;

                for(int i=si;i<=ei;i++)
                {
                    int leftc=si==i ? 0: dp[si][i-1];
                    int rightc=ei==i? 0:dp[i+1][ei];

                    max=Math.max(max,leftc+left*nums[i]*right+rightc);
                }
                dp[si][ei]=max;
            }
        }
        
        // for(int []i:dp)
        // {
        //     for(int j:i)
        //     {
        //         System.out.println(j);
        //     }
        // }

        return dp[0][nums.length-1];
    }
}