class Solution {
    public int maxProfit(int[] prices) {
       int max=prices[prices.length-1];
        int maxprice=0;
        
        for(int i=prices.length-2;i>=0;i--)
        {
            max=Math.max(max,prices[i]);
            maxprice=Math.max(maxprice,max-prices[i]);
        }
        return maxprice;
    }
}