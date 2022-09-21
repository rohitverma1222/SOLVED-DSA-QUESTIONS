class MapSum {
    class Node{
        Node children[]=new Node[26];
        boolean eow=false;
        int val=0;
    } 
    Node root;
    public MapSum() {
        root=new Node();
    }
    
    public void insert(String key, int val) {
        Node node=root;
        for(char ch:key.toCharArray())
        {
            if(node.children[ch-'a']==null)
                node.children[ch-'a']=new Node();
            node=node.children[ch-'a'];
        }
        node.val=val;
        node.eow=true;
    }
    
    public int sum(String prefix) {
        Node node=root;
        for(char ch:prefix.toCharArray())
        {
            if(node.children[ch-'a']==null)
                return 0;
            node=node.children[ch-'a'];
        }
        return total(node);
    }
    public int total(Node root)
    {
        int sum=0;
        for(Node ch:root.children)
        {
            if(ch!=null)
                sum+=total(ch);
        }
        return root.val+sum;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */