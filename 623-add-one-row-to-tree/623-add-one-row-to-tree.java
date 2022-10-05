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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1)
        {
            TreeNode node=new TreeNode(val);
            node.left=root;
            return node;
        }
         helper(root,val,depth-1,0);
        return root;
    }
    public void helper(TreeNode root,int val,int depth,int curr)
    {
        if(root==null)
            return ;
        if(depth-1==curr)
        {
            TreeNode l=new TreeNode(val);
            TreeNode subtree=root.left;
            l.left=subtree;
            root.left=l;
            
            TreeNode r=new TreeNode(val);
            TreeNode subtre=root.right;
            r.right=subtre;
            root.right=r;
            
        }
        helper(root.left,val,depth,curr+1);
        helper(root.right,val,depth,curr+1);
    }
}