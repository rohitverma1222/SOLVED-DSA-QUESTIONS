class Solution {
    public int maxProfit(int[] prices) {
        int s=0;
        int e=0;
        int ans=0;
        for(int i=1;i<prices.length;i++)
        {
            if(prices[i-1]<=prices[i])
            {
                s++;
            }
            else{
                ans+=prices[s]-prices[e];
                s=e=i;
            }
        }
        ans+=prices[s]-prices[e];
        return ans;
    }
}