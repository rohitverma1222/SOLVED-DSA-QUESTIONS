class Solution {
    public int findKthNumber(int m, int n, int k) {
        int l=1;
        int h=m*n;

        int j=0;

        while(l<h)
        {
            int mid=l+(h-l)/2;
             j=n;
            int c=0;
            for(int i=1;i<=m;i++)
            {
                while(j>0 && i*j>mid)
                    j--;
                c+=j;
            }
            if(c<k)
                l=mid+1;
            else
                h=mid;
        }
        return l;
    }
}