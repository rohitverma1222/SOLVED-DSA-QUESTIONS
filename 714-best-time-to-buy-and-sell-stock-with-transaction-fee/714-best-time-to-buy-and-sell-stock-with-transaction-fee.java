class Solution {
    public int maxProfit(int[] prices, int fee) {
        int bought=-prices[0];
        int sell=0;

        for(int i=1;i<prices.length;i++)
        {
            int newBought=sell-prices[i];
            int newSell=bought+prices[i]-fee;

            bought=Math.max(newBought,bought);
            sell=Math.max(newSell,sell);
        }
        return sell;
    }
}