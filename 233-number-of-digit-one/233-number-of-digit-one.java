class Solution {
    public int countDigitOne(int n) {
        if(n==0)
            return 0;
        int power=1;
        int ans=0;
        while(power<=n)
        {
            int a=n/(power*10);
            int b=n%(power*10);
            int delta=0;
            if(b<power)
            {
                delta=0;
            }
            else if(b<2*power)
            {
                delta=b-power+1;
            }
            else{
                delta=power;
            }
            ans+=(a*power)+delta;
            power*=10;
        }
        return ans;
    }
}