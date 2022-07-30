class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);

        for(int i=0;i<costs.length;i++)
        {
            if(coins-costs[i]<0)
                return i;
            coins-=costs[i];
            if(coins==0)
                return i+1;
        }
        if(coins>0)
            return costs.length;
        return 0;
    }
}