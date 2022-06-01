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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)
            return null;
        if(key<root.val)
        {
            root.left=deleteNode(root.left,key);
            return root;
        }
        else if(key>root.val)
        {
            root.right= deleteNode(root.right,key);
            return root;
        }
        else
        {
            if(root.left==null && root.right==null)
                return null;
            else if(root.left==null)
            {
                return root.right;
            }
            else if(root.right==null)
                return root.left;
            else
            {
                int m=max(root.right);
                root.val=m;
                root.right=deleteNode(root.right,m);
                return root;
            }
        }
    }
    public int max(TreeNode root)
    {
        if(root.left==null)
            return root.val;
        else
            return max(root.left);
    }
}