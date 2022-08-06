class Solution {
    public int minimumSize(int[] nums, int h) {
        int lo=1;
        int hi=0;
        for(int i:nums)
        {
            hi=Math.max(hi,i);
        }


        while(lo<hi)
        {
            int mid=(lo+hi)/2;

            int hours=0;
            for(int i:nums)
            {
                if(i>mid)
                {
                    int spr=i-mid;
                hours+=(spr+mid-1)/mid;
                }
            }

            if(hours<=h)
            {
                hi=mid;
            }
            else{
                lo=mid+1;
            }
        }
        return lo;
    }
}