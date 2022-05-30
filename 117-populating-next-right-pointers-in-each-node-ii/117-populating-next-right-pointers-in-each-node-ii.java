/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Queue<Node> mq=new LinkedList();
        if(root==null)
            return root;
        mq.add(root);
        
        while(mq.size()>0)
        {
            int s=mq.size();
            
                Node prev=null;
                for(int i=0;i<s;i++)
                {
                    Node rem=mq.remove();
                    
                    if(prev!=null)
                    {
                        prev.next=rem;
                    }
                    prev=rem;
                    
                    if(rem.left!=null)
                    {
                        mq.add(rem.left);
                    }
                    if(rem.right!=null)
                    {
                        mq.add(rem.right);
                    }
                }   
            
        }
        return root;
    }
}