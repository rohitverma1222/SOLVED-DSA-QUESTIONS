class Solution {
    public int minimumCardPickup(int[] cards) {
        HashMap<Integer,Integer> hs=new HashMap<>();
        int min=Integer.MAX_VALUE;
        int i=0;
        int j=0;
        while(i<cards.length)
        {
            hs.put(cards[i],hs.getOrDefault(cards[i],0)+1);
            while(hs.get(cards[i])==2)
                {
                    
                    min=Math.min(min,i-j+1);
                    hs.put(cards[j],hs.getOrDefault(cards[j],0)-1);
                    if(hs.get(cards[j])==0)
                    {
                        hs.remove(cards[j]);
                    }

                    j++;
                }
            i++;
        }
        return min==Integer.MAX_VALUE?-1:min;
    }
}