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
    int result=0;
    class pair {
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        boolean currbst=true;
        int sum=0;
    }
    public int maxSumBST(TreeNode root) {
        helper(root);
        return result;
    }
    public pair helper(TreeNode root)
    {
        if(root==null)
            return new pair();
        
        pair le=helper(root.left);
        pair ri=helper(root.right);
        
        pair my=new pair();
        
        if(le.max<root.val && ri.min>root.val)
        {
            if(le.currbst && ri.currbst)
            {
                my.currbst=true;
                my.sum+=le.sum+ri.sum+root.val;
                result=Math.max(result,my.sum);
            }
            else
            {
                my.currbst=false;
                my.sum+=Math.max(le.sum,ri.sum);
                result=Math.max(result,my.sum);
                
            }
        }
        else
        {
            my.currbst=false;
                my.sum+=Math.max(le.sum,ri.sum);
                result=Math.max(result,my.sum);
            
            
        }
        
        my.max=Math.max(le.max,Math.max(root.val,ri.max));
        my.min=Math.min(le.min,Math.min(root.val,ri.min));
        return my;
    }
}