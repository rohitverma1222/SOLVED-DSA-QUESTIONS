class Solution {
    public boolean isUgly(int n) {
        if(n==0)
            return false;
        int []dir={2,3,5};
        
        for(int d:dir)
        {
            while(n%d==0)
            {
                n/=d;
            }
        }
        return n==1;
    }
}