class Solution {
    public int splitArray(int[] nums, int m) {
        int lo=Integer.MIN_VALUE;
        int hi=0;
        for(int i:nums)
        {
            hi+=i;
            lo=Math.max(lo,i);
        }


        while(lo<hi)
        {
            int mid=(lo+hi)/2;

            int part=1;
            int sum=0;

            for(int i:nums)
            {
                if(sum+i<=mid)
                {
                    sum+=i;
                }
                else{
                    sum=i;
                    part++;
                }
            }

            if(part>m)
            {
                lo=mid+1;
            }
            else{
                hi=mid;
            }
        }
        return lo;
    }
}