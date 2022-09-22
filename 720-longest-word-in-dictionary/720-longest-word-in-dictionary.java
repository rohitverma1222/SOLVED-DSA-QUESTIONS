class Solution {
    class Node{
        boolean eow;
        Node []arr=new Node[26];
    }
    Node root;
    String big="";
    public String longestWord(String[] words) {
        root=new Node();
        big="";
        insert(words);
        traverse(root,"");
        return big;
    }
    public void traverse(Node root,String ssf)
    {
        if(big.length()<ssf.length())
        {
            big=ssf;
        }
        for(char ch='a';ch<='z';ch++)
        {
            Node node=root.arr[ch-'a'];
            if(node!=null && node.eow)
            {
                traverse(node,ssf+ch);
            }
        }
    }
    public void insert(String []words)
    {
        for(String str:words)
        {
            Node temp=root;
            for(char ch:str.toCharArray())
            {
                if(temp.arr[ch-'a']==null)
                    temp.arr[ch-'a']=new Node();
                temp=temp.arr[ch-'a'];
            }
            temp.eow=true;
        }
    }
}