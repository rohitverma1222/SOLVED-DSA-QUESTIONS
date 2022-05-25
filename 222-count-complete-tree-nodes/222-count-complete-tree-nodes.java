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
    public int countNodes(TreeNode root) {
        if(root==null)
            return 0;
        int lh=0;
        TreeNode node=root.left;
        while(node!=null)
        {
            node=node.left;
            lh++;
        }
        
        int rh=0;
         node=root.right;
        while(node!=null)
        {
            node=node.right;
            rh++;
        }
        if(lh==rh)
        {
            return (1<<(lh+1))-1;
        }
            
        int left=countNodes(root.left);
        int right=countNodes(root.right);
        
        return left+right+1;
    }
}