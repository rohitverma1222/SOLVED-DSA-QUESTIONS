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
        helper(root);
        return max;
    }
    public int helper(TreeNode root)
    {
        if(root==null)
            return 0;
        
        int l=helper(root.left);
        int r=helper(root.right);
        
        int l_dash=Math.max(l,0);
        int r_dash=Math.max(r,0);
        
        max=Math.max(max,l_dash+r_dash+root.val);
        
        return Math.max(l_dash,r_dash)+root.val;
    }
}