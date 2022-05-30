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
    class pair{
        boolean isbst;
        long max;
        long min;
        pair()
        {
            this.isbst=true;
            this.max=Long.MIN_VALUE;
            this.min=Long.MAX_VALUE;
        }
    }
    public boolean isValidBST(TreeNode root) {
        if(root==null)
            return true;
        
        if(root!=null && root.left==null && root.right==null)
            return true;
        pair ans=helper(root);
        return ans.isbst;
    }
    public pair helper(TreeNode root)
    {
        if(root==null)
            return new pair();
        
        pair le=helper(root.left);
        pair ri=helper(root.right);
        
        pair ans=new pair();
        boolean is=false;
        if(le.max<root.val && ri.min>root.val && le.isbst && ri.isbst)
            is=true;
        
        ans.isbst=is;
        ans.max=Math.max(root.val,Math.max(le.max,ri.max));
        ans.min=Math.min(root.val,Math.min(le.min,ri.min));
        return ans;
    }
}