class Solution {
    public boolean searchMatrix(int[][] matrix, int tar) {
        int i=matrix.length-1;
        int j=0;
        while(i>=0 && i<matrix.length)
        {
            if(j==matrix[0].length)
                return false;
            if(tar==matrix[i][j])
                return true;
            else if(tar<matrix[i][j])
                i--;
            else if(tar>matrix[i][j])
                j++;
        }
        return false;
    }
}