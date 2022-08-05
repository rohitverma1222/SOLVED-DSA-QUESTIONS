class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int lo=1;
        int hi=1000000;

        while(lo<hi)
        {
            int mid=(lo+hi)/2;
            int res=0;
            for(int i:nums)
            {
                res+=(i+mid-1)/mid;
            }

            if(res>threshold)
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