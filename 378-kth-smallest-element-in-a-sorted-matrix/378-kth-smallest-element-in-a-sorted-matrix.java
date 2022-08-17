class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n=matrix.length;
        int l=matrix[0][0];
        int h=matrix[n-1][n-1];

        while(l<h)
        {
            int mid=l+(h-l)/2;
        int j=n-1;
            int sum=0;
            for(int i=0;i<matrix.length;i++)
            {
                while (j>=0 && matrix[i][j]>mid) {
                    j--;
                }
                sum+=(j+1);
            }
            if(sum<k)
            {
                l=mid+1;
            }
            else{
                h=mid;
            }
        }
        return l;
    }
}