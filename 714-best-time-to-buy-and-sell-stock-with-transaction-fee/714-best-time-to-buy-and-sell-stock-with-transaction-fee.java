class Solution {
    public int maxProfit(int[] prices, int fee) {
        int buy=-prices[0];
        int sell=0;
        for(int i=1;i<prices.length;i++)
        {
            int Newbuy=sell-prices[i];
            int Newsell=buy+prices[i]-fee;

            buy=Math.max(Newbuy,buy);
            sell=Math.max(Newsell,sell);
        }
        return sell;
    }
}