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
            TreeNode n=new TreeNode(val);
            n.left=root;
            return n;
        }
        helper(root,val,depth,1);
        return root;
    }
    public void helper(TreeNode root,int val,int depth,int curr)
    {
        if(root==null)
            return ;
        
        if(curr==depth-1)
        {
            TreeNode cat=root.left;
            TreeNode n=new TreeNode(val);
            n.left=cat;
            root.left=n;
            
            cat=root.right;
            TreeNode nn=new TreeNode(val);
            nn.right=cat;
            root.right=nn;
        }
            
        helper(root.left,val,depth,curr+1);
        helper(root.right,val,depth,curr+1);
        
    }
}