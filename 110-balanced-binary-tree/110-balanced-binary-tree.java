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
    boolean bal=true;
    public boolean isBalanced(TreeNode node) {
        if(node==null)
            return true;
        if(node.left==null &&node.right==null)
            return true;
        
        
        isbal(node);
        return bal;
  }
    public int isbal(TreeNode node)
  {
      if(node==null)
      return -1;
      // int h=-1;
      int l=isbal(node.left);
      int r=isbal(node.right);
      
      if(Math.abs(l-r)>1)
      {
          bal=false;
      }
        return Math.max(l,r)+1;
      // return h;
  }
}