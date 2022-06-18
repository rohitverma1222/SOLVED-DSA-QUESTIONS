class Solution {
    public long gridGame(int[][] grid) {
        long top=Arrays.stream(grid[0]).asLongStream().sum();
        long bottom=0;
        long ans=Long.MAX_VALUE;
        for(int i=0;i<grid[0].length;i++)
        {
         top-=grid[0][i];
            ans=Math.min(ans,Math.max(top,bottom));
            bottom+=grid[1][i];
        }
                        return ans;
    }
}