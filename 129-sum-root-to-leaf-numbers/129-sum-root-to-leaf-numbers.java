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
    int sum=0;
    public int sumNumbers(TreeNode root) {
         helper(root,root.val+"");
        return sum;
    }
    public void helper(TreeNode root,String str)
    {
        if(root.left==null && root.right==null)
        {
            sum+=Integer.parseInt(str);
            return ;
        }
        if(root.left!=null)
        helper(root.left,str+root.left.val);
        
        if(root.right!=null)
            helper(root.right,str+root.right.val);
    }
}