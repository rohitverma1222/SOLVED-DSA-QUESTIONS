/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode ref=null;
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        helper(cloned,target);
        return ref;
    }
    public void helper(TreeNode node,TreeNode tar)
    {
        if(node==null)
            return ;;
        if(node.val==tar.val)
        {
            ref=node;
            return;
        }
        
        helper(node.left,tar);
        helper(node.right,tar);
    }
}