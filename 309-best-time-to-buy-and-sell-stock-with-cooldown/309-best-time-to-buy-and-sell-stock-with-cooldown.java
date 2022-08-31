class Solution {
    public int maxProfit(int[] prices) {
        int brought=-prices[0];
        int sell=0;
        int cooldown=0;
        for(int i=1;i<prices.length;i++)
        {
            int newBrought=cooldown-prices[i];
            int newSell=brought+prices[i];
            int newCooldown=sell;

            brought=Math.max(brought,newBrought);
            cooldown=Math.max(newCooldown,cooldown);
            sell=Math.max(newSell,sell);

        }
        return sell;
    }
}