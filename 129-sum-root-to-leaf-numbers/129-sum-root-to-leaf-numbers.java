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
        StringBuilder str=new StringBuilder();
        // str.append(root.val);
         helper(root,str);
        return sum;
    }
    public void helper(TreeNode root,StringBuilder str)
    {
        if(root==null)
            return;
        if(root!=null && root.left==null && root.right==null)
        {
            str.append(root.val);
            System.out.println();
            sum+=Integer.parseInt(str.toString());
        str.setLength(str.length() - 1);
            
            return ;
        }
        str.append(root.val);
        helper(root.left,str);
        helper(root.right,str);
        str.setLength(str.length() - 1);
        
    }
}