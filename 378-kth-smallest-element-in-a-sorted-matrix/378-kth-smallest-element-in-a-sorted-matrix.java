class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n=matrix.length;
        int l=matrix[0][0];
        int h=matrix[n-1][n-1];
        while(l<h)
        {
            int mid=l+(h-l)/2;
            int j=n-1;
            int c=0;
            for(int i=0;i<n;i++)
            {
                while(j>=0 && matrix[i][j]>mid)
                {
                    j--;
                }

                c+=(j+1);
            }

            if(c<k)
                l=mid+1;
            else{
                h=mid;
            }
        }
        return l;
    }
}