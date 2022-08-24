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
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root==null)
            return 0;
        if(root.left==null && root.right==null)
            return root.val;

        int val=helper(root);
        return Math.max(val,max);
    }
    public int helper(TreeNode root)
    {
        if(root==null)
            return 0;

        int left=helper(root.left);
        int right=helper(root.right);

        int ld=Math.max(left,0);
        int rd=Math.max(right,0);
        max=Math.max(ld+rd+root.val,max);
        return Math.max(rd,ld)+root.val;
    }
}