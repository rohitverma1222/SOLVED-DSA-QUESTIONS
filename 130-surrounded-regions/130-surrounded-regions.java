 class Solution {
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        boolean visited[][]=new boolean[n][m];

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(board[i][j]=='O' && (i == 0 || j == 0 || i == n - 1 || j == m - 1))
                {
                    helper(board,i,j,visited);
                }
            }
        } 
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(board[i][j]=='O')
                {
                    board[i][j]='X';
                }
                else if(board[i][j]=='-')
                {
                    board[i][j]='O';
                }
            }
        } 
    }
    int [][]dir={{-1,0},{1,0},{0,-1},{0,1}};
    public void helper(char board[][],int i,int j,boolean [][]visited)
    {
        if(i<0 || j<0 || i>=board.length || j>=board[0].length ||board[i][j]!='O')
            return ;
        visited[i][j]=true;
        board[i][j]='-';

        helper(board,i+1,j,visited);
        helper(board,i-1,j,visited);
        helper(board,i,j+1,visited);
        helper(board,i,j-1,visited);
    }
}