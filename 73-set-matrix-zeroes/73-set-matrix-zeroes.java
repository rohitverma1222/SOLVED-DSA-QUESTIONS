class Solution {
    public void setZeroes(int[][] matrix) {
        boolean iscol=false;
        int n=matrix.length;
        int m=matrix[0].length;

        for(int i=0;i<n;i++)
        {
            if(matrix[i][0]==0)
            {
                iscol=true;
            }
            for(int j=1;j<m;j++)
            {
                if(matrix[i][j]==0)
                {
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }

        for(int i=1;i<n;i++)
        {
            for(int j=1;j<m;j++)
            {
                if(matrix[i][0]==0||matrix[0][j]==0 )
                    matrix[i][j]=0;
            }
        }
        
        if(matrix[0][0]==0)
        {
            for(int i=0;i<m;i++)
            {
                matrix[0][i]=0;
            }
        }
        if(iscol)
        {
            for(int i=0;i<n;i++)
            {
                matrix[i][0]=0;
            }
        }
    }
}