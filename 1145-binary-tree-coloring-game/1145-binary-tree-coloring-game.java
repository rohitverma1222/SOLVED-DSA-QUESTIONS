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
    public int size(TreeNode node,int x){
        if(node==null)
            return 0;
        int ls=size(node.left,x);
        int rs=size(node.right,x);
        
        if(node.val==x)
        {
            xleft=ls;
            yleft=rs;
        }
        return ls+rs+1;
        
    }
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        size(root,x);
        
        int other=n-(xleft+yleft+1);
        int max=Math.max(other,Math.max(xleft,yleft));
        // if(other>)
        return max>n/2;
    }
}