class Solution {
    long mod=1000000007;
    public int countHousePlacements(int n) {
        int one=1;
        int zero=1;
        for(int i=0;i<n-1;i++)
        {
            int x=one;
            int y=one+zero;

            zero=(int)(x%mod);
            one=(int)(y%mod);
        }
        long val=(one+zero)%mod;
        return (int)((val*val)%mod);
    }
}