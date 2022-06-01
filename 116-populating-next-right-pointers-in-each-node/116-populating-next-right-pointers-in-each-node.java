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
        Node curr=root;
        Node p=null;
        while(curr!=null)
        {
            p=curr;
            while(p!=null)
            {
                if(p.left!=null)
                {
                    p.left.next=p.right;
                }
                if(p.right!=null && p.next!=null)
                {
                    p.right.next=p.next.left;
                }
                    
                p=p.next;
            }
            curr=curr.left;
        }
        return root;
    }
}