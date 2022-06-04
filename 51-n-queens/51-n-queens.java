class Solution {
    List<List<String>> ans=new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        boolean [][]chess=new boolean[n][n];
        helper(chess,new boolean[n],0,new boolean[2*n-1],new boolean[2*n-1]);
        return ans;
    }
    public void helper(boolean [][]chess,boolean []col,int row,boolean []rdia,boolean []dia)
    {
           if(row==chess.length)
           {
            List<String> li=new ArrayList<>();
            for(int i=0;i<chess.length;i++)
            {
                String str="";
                for(int j=0;j<chess[0].length;j++)
                {
                    if(chess[i][j]==false)
                    {
                        str+=".";
                    }
                    else{
                        str+="Q";
                    }
                }
                li.add(str);
               // System.out.println(str);
            }
            ans.add(new ArrayList<>(li));
            return;
           }

           for(int i=0;i<chess.length;i++)
           {
                if(!chess[row][i] && col[i]==false && !rdia[row-i+chess.length-1] && !dia[row+i])
                {
                    chess[row][i]=true;
                    col[i]=true;
                    rdia[row-i+chess.length-1]=true;
                    dia[row+i]=true;
                    
                    helper(chess,col,row+1,rdia,dia);

                    chess[row][i]=false;
                    col[i]=false;
                    rdia[row-i+chess.length-1]=false;
                    dia[row+i]=false;
                }
           }
    }
}