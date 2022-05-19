class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int [][]mem=new int[m][n];
    int max=0;
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                max=Math.max(max,dfs(matrix,1,new boolean[m][n],i,j,mem));
            }
        }
        return max;
    }
    int [][]dir={{1,0},{0,1},{-1,0},{0,-1}};
    public int dfs(int [][]matrix,int m,boolean [][]visited,int i,int j,int [][]mem)
    {
        if(mem[i][j]>0)
            return mem[i][j];
        int max=0;
        for(int []d:dir)
        {
            int ni=i+d[0];
            int nj=j+d[1];
            
            if(ni>=0 && nj>=0 && ni<matrix.length && nj<matrix[0].length)
            {
                if(matrix[ni][nj]>matrix[i][j])
                    max=Math.max(dfs(matrix,m+1,visited,ni,nj,mem),max);
            }
        }
        mem[i][j]=max+1;
        return max+1;
    }
}