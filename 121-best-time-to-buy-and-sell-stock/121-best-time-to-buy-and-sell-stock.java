class Solution {
    public int maxProfit(int[] prices) {
        int max=prices[0];
        int ans=0;
        for(int i=1;i<prices.length;i++)
        {
            max=Math.min(max,prices[i]);
            ans=Math.max(ans,prices[i]-max);
        }
        return ans;
    }
}