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
        int sum;
        int c;
        pair()
        {
            this.sum=0;
            this.c=0;
        }
    }
    int count=0;
    public int averageOfSubtree(TreeNode root) {
        helper(root);
        return count;
    }
    public pair helper(TreeNode root)
    {
        if(root==null)
            return new pair();
        
        pair left=helper(root.left);
        pair ri=helper(root.right);
        pair my=new pair();
        my.sum=left.sum+ri.sum+root.val;
        my.c=left.c+ri.c+1;
        int val=my.sum/my.c;
        if(val==root.val)
            count++;
        
        return my;
    }
}