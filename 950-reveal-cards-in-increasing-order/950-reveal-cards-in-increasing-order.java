class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);

        int k=1;
        int n=deck.length;
        int c=0;
        int res[]=new int[n];
        res[0]=deck[0];
        while(k<n)
        {
            for(int i=1;i<n;i++)
            {
                if(res[i]==0)
                {
                    c++;
                    if(c==2)
                    {
                        res[i]=deck[k++];
                        c=0;
                    }
                }
            }
        }
        return res;
    }
}