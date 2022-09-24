class Solution {
    class Node{
        boolean eow=false;
        Node []children=new Node[26];
    }
    Node root=new Node();
    public List<String> findWords(char[][] board, String[] words) {
        for(String str:words)
        {
            insert(str);
        }

        boolean visited[][]=new boolean[board.length][board[0].length];
        for(int i=0;i<visited.length;i++)
        {
            for(int j=0;j<visited[0].length;j++)
            {
                helper(board,i,j,new StringBuilder(),root,visited);
            }
        }
        return new ArrayList<>(res);
    }
    HashSet<String> res=new HashSet<>();
    int [][]dir={{1,0},{-1,0},{0,1},{0,-1}};
    public void helper(char [][]board,int i,int j,StringBuilder str,Node root,boolean [][]visited)
    {
        char ch=board[i][j];
        str.append(ch);
        if(root.children[ch-'a']==null)
        {
            str.deleteCharAt(str.length()-1);
            return;
        }
        Node child=root.children[ch-'a'];
        if(child.eow)
        {
            res.add(str.toString());
        }
        visited[i][j]=true;
        for(int []d:dir)
        {
            int ni=i+d[0];
            int nj=j+d[1];
            if(ni>=0 && nj>=0 && ni<board.length && nj<board[0].length && visited[ni][nj]==false)
                helper(board,ni,nj,str,child,visited);
        }
        visited[i][j]=false;
        str.deleteCharAt(str.length()-1);
    }
    public void insert(String word)
    {
        Node temp=root;
        for(char ch:word.toCharArray())
        {
            if(temp.children[ch-'a']==null)
                temp.children[ch-'a']=new Node();
            temp=temp.children[ch-'a'];
        }
        temp.eow=true;
    }
}