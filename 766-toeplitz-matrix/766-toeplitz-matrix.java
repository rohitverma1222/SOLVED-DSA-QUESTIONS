class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;

        for(int i=0;i<n-1;i++)
        {
            int []arr1=Arrays.copyOfRange(matrix[i],0,m-1);
            int []arr2=Arrays.copyOfRange(matrix[i+1],1,m);
            if(Arrays.equals(arr1,arr2)==false)
                return false;
        }
        return true;
    }
}