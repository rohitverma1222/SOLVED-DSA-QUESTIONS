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
    int xleft=0;
    int yleft=0;
    public int size(TreeNode root,int x)
    {
        if(root==null)
            return 0;
        int left=size(root.left,x);
        int right=size(root.right,x);
        if(root.val==x)
        {
            xleft=left;
            yleft=right;
        }
        return left+right+1;
    }
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        size(root,x);
        return Math.max(n-(yleft+xleft+1),Math.max(xleft,yleft))>n/2;
    }
}