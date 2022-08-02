class Solution {
    public int countPrimes(int n) {
        if(n==0 || n==1)
            return 0;
        
        boolean []ans=new boolean[n];
        int c=1;
        for(int i=2;i*i<n;i++)
        {
            if(ans[i]==false)
            {
                for(int j=i;j*i<n;j++)
                {
                    if(ans[j*i]==false)
                    {
                        c++;
                        ans[j*i]=true;
                    }
                }
            }
        }
        return n-c-1;
    }
}