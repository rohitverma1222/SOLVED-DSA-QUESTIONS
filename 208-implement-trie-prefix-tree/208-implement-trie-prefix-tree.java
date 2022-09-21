class Trie {
    class Node{
        boolean endOfWord=false;
        Node []children=new Node[26];    
    }
    Node root;
    public Trie() {
        root=new Node();
    }
    
    public void insert(String word) {
        Node temp=root;
        for(char ch:word.toCharArray())
        {
            if(temp.children[ch-'a']==null)
                temp.children[ch-'a']=new Node();
            temp=temp.children[ch-'a'];
        }
        temp.endOfWord=true;
    }
    
    public boolean search(String word) {
        Node temp=root;
        for(char ch:word.toCharArray())
        {
            if(temp.children[ch-'a']==null)
                return false;
            temp=temp.children[ch-'a'];
        }
        return temp.endOfWord;
    }
    
    public boolean startsWith(String prefix) {
        Node temp=root;
        for(char ch:prefix.toCharArray())
        {
            if(temp.children[ch-'a']==null)
                return false;

            temp=temp.children[ch-'a'];
        }
        return true;
    }
}