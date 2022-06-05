class Solution {
    int c=0;
    public int totalNQueens(int n) {
        if(n==1)
            return 1;
        boolean [][]board=new boolean[n][n];
        solution(board,0,new boolean[n],new boolean[2*n-1],new boolean[n*2-1]);
        return c;
    }
     public void solution(boolean [][]board, int row,boolean[] col,boolean[] ndiag,boolean []rdiag)
    {
//         base Case 
        if(row==board.length)
        {
           c++;
            
            return;
        }
          
//         Main Logic Part
        for(int i=0;i<board.length;i++)
        {
            if(!col[i] && !ndiag[row+i] && !rdiag[row-i+board.length-1])
            {
                board[row][i]=true;
                col[i]=true;
                ndiag[row+i]=true;
                rdiag[row-i+board.length-1]=true;
                
                solution(board,row+1,col,ndiag,rdiag);
                
                board[row][i]=false;
                col[i]=false;
                ndiag[row+i]=false;
                rdiag[row-i+board.length-1]=false;
            }
        }
    }
}