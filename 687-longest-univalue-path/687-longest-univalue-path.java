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
    int len=-1;
    public int longestUnivaluePath(TreeNode root) {
        helper(root,-1);
        if(len<=0)
            return 0;
        return len-1;
    }
    public int helper(TreeNode root,int val)
    {
        if(root==null)
        {
            return 0;
        }
        int x=helper(root.left,root.val);
        int y=helper(root.right,root.val);
        
            len=Math.max(len,x+y+1);
        if(root.val==val)
        {
            return Math.max(x,y)+1;
        }
        else
            return 0;
    }
}