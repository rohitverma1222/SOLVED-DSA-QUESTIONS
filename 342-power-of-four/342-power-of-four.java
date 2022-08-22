class Solution {
    public boolean ispow(int n)
    {
        return n>0 && ((n&((n-1)))==0);
    }
        public boolean isPowerOfFour(int n) {
        if(!ispow(n))
            return false;
        int c=0;
        while(n!=1)
        {
            n=n>>>1;
            c++;
        }
            System.out.println(c);
        return c%2==0;
    }
}