class Solution {
    int mod=(int)1e9+7;
    public int numberOfPaths(int[][] grid, int k) {
        int [][][]dp=new int[grid.length][grid[0].length][50];
        for(int i[][]:dp)
            for(int j[]:i)
                Arrays.fill(j,-1);
        return helper(grid,0,0,0,k,dp);
    }
    public int helper(int [][]grid,int i,int j,int sum,int k,int [][][]dp)
    {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length)
            return 0;
        
        if(i==grid.length-1 && j==grid[0].length-1)
        {
            sum+=grid[grid.length-1][grid[0].length-1];
            return sum%k==0?1:0;
        }
        if(dp[i][j][sum%k]!=-1)
            return dp[i][j][sum%k];
        
        int a=helper(grid,i+1,j,sum+grid[i][j],k,dp)%mod;
        int b=helper(grid,i,j+1,sum+grid[i][j],k,dp)%mod;
        return dp[i][j][sum%k]=((a+b)%mod);
    }
}