class WordDictionary {
    class Node{
        boolean eow=false;
        Node []children=new Node[26];
    }
    Node root;
    public WordDictionary() {
        root=new Node();
        
    }
    
    public void addWord(String word) {
        Node node=root;
        for(char ch:word.toCharArray())
        {
            if(node.children[ch-'a']==null)
            {
                node.children[ch-'a']=new Node();
            }
            node=node.children[ch-'a'];
        }
        node.eow=true;
    }
    
    public boolean search(String word) {
        return helper(root,word,0,false);
    }
    public boolean helper(Node root,String word,int i,boolean end)
    {
        if(i>=word.length())
            return end;
        if(word.charAt(i)!='.')
        {
            if(root.children[word.charAt(i)-'a']==null)
                return false;
            if(helper(root.children[word.charAt(i)-'a'],word,i+1,root.children[word.charAt(i)-'a'].eow))
                return true;
        }
        else{
            for(Node ch:root.children)
            {
                if(ch!=null)
                {
                    if(helper(ch,word,i+1,ch.eow))
                        return true;
                }
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */