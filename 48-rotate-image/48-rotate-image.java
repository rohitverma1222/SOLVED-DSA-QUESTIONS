class Solution {
    public void rotate(int[][] matrix) {
//         transpose
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=i+1;j<matrix[0].length;j++)
            {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
        
        // for(int i=0;i<matrix.length;i++)
        // {
        //     for(int j=0;j<matrix[0].length;j++)
        //     {
        //         System.out.print(matrix[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        
        for(int k=0;k<matrix.length;k++)
        {
        int i=0;
        int j=matrix[0].length-1;
            while(i<j)
            {
                int tem=matrix[k][i];
                matrix[k][i]=matrix[k][j];
                matrix[k][j]=tem;
                i++;
                j--;
            }
        }
    }
}