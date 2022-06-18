class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long lo = 0, hi = 100_000_000_000_000L;
        while(lo<hi)
        {
            long mid=lo+(hi-lo)/2;
            long trip=0;
            for(int i:time)
                trip+=mid/i;
            
            if(trip<totalTrips)
                lo=mid+1;
            else
                hi=mid;
        }
        return lo;
    }
}