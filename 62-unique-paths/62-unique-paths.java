class Solution {
    public int uniquePaths(int m, int n) {
        int [][]arr=new int[m][n];
        arr[m-1][n-1]=1;
        
        int [][]dir={{1,0},{0,1}};
        for(int i=m-1;i>=0;i--)
        {
            for(int j=n-1;j>=0;j--)
            {
                for(int []d:dir)
                {
                    int ni=d[0]+i;
                    int nj=d[1]+j;
                    
                    if(ni>=0 && nj>=0 && ni<m && nj<n)
                    {
                        arr[i][j]+=arr[ni][nj];
                    }
                }
            }
        }
        return arr[0][0];
    }
}