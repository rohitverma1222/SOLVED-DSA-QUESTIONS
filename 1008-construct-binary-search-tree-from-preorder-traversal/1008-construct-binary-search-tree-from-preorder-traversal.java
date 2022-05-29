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
        return con(preorder,Integer.MAX_VALUE,Integer.MIN_VALUE);
    }
    public TreeNode con(int []pre,int max,int min)
    {
        if(index==pre.length)
        {
            return null;
        }
        else if(pre[index]>min && pre[index]<max)
        {
            TreeNode node=new TreeNode();
            node.val=pre[index];
            index++;
            
            node.left=con(pre,node.val,min);
            node.right=con(pre,max,node.val);
            
            return node;
        }
        else
            return null;
        
    }
}