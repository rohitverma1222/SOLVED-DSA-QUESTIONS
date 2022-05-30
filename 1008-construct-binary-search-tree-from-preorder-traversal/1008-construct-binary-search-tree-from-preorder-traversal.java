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
    int index=0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder,Integer.MAX_VALUE,Integer.MIN_VALUE);
    }
    public TreeNode helper(int []pre,int max,int min)
    {
        if(index==pre.length)
            return null;
        else if(pre[index]<max && pre[index]>min)
        {
            TreeNode node=new TreeNode(pre[index]);
            index++;
            
            node.left=helper(pre,node.val,min);
            node.right=helper(pre,max,node.val);
            
            return node;
        }
        else
            return null;
    }
}