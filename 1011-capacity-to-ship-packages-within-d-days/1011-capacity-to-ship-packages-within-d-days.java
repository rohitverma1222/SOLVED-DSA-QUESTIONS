class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int hi=0;
        int lo=Integer.MIN_VALUE;

        for(int i:weights)
        {
            hi+=i;
            lo=Math.max(i,lo);
        }

        while(lo<hi)
        {
            int limit=(lo+hi)/2;

            int part=1;
            int sum=0;

            for(int i:weights)
            {
                if(sum+i<=limit)
                {
                    sum+=i;
                }
                else{
                    sum=i;
                    part++;
                }
            }

            if(part>days)
            {
                lo=limit+1;
            }
            else{
                hi=limit;
            }
        }
        return lo;
    }
}