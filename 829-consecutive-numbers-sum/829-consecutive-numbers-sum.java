class Solution {
    public int consecutiveNumbersSum(int n) {
        int k=1;
        int check=k*(k-1)/2;
        int ret=0;
        while(check<n)
        {
            if((n-check)%k==0)
            {
                ret++;
            }
            k++;
            check=k*(k-1)/2;
        }
        return ret;
    }
}