class Solution {
    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int max=1;
            for(int i:coins)
            {
                if(i>max)
                    break;
                
                max+=i;
            }
        return max;
    }
}