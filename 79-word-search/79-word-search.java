class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length, cols = board[0].length;                               
		if(word.length() == 0){ return true; }                                          // if "word" is empty, we will just return true. 
		if(rows * cols < word.length()){ return false; }   

        
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(board[i][j]==word.charAt(0))
                {
                    if(helper(board,word,new boolean[rows][cols],i,j,0))
                        return true;
                }
            }
        }
        return false;
    }
    public boolean helper(char [][]board,String rest,boolean [][]visited,int i,int j,int sel){
        if(i<0 || j<0 || i>=board.length ||j>=board[0].length ||visited[i][j]==true|| board[i][j]!=rest.charAt(sel))
        {
            return false;
        }
        
        if(rest.length()-1==sel)
            return true;
        visited[i][j]=true;
        
        if(helper(board,rest,visited,i+1,j,sel+1))
            return true;
         if(helper(board,rest,visited,i-1,j,sel+1))
            return true;
        if(helper(board,rest,visited,i,j+1,sel+1))
            return true;
        if(helper(board,rest,visited,i,j-1,sel+1))
            return true;
        
        visited[i][j]=false;
        
        return false;
        
    }
}