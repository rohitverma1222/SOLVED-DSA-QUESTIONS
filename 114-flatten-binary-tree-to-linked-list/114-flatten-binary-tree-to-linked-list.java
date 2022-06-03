/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    class pair{
        TreeNode head=null;
        TreeNode tail=null;
        pair(){
            
        }
        pair(TreeNode head,TreeNode tail)
        {
            this.head=head;
            this.tail=tail;
        }
    }
    public void flatten(TreeNode root) {
        if(root!=null)
         helper(root);
    }
    public pair helper(TreeNode root)
    {
        if(root.left!=null && root.right!=null)
        {
            pair left=helper(root.left);
            pair right=helper(root.right);
            
            pair my=new pair();
            my.head=root;
            my.head.left=null;
            my.head.right=left.head;
            left.tail.right=right.head;
            my.tail=right.tail;
            
            return my;
        }
        else if(root.left!=null)
        {
            pair left=helper(root.left);
            
            pair my=new pair();
            my.head=root;
            my.head.left=null;
            my.head.right=left.head;
            my.tail=left.tail;
            return my;
        }
        else if(root.right!=null)
        {
            pair right=helper(root.right);
            pair my=new pair();
            my.head=root;
            my.head.left=null;
            my.head.right=right.head;
            my.tail=right.tail;
            return my;
        }
        else
            return new pair(root,root);
    }
}