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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> hs=new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        {
            int val=inorder[i];
            hs.put(val,i);
        }
        // int n=preorder.length-1;
        TreeNode root=construct(0,preorder.length-1,0,inorder.length-1,preorder,hs);
        return root;
    }
    public TreeNode construct(int pre_lo,int pre_hi,int in_lo,int in_hi,int []preorder,HashMap<Integer,Integer> hs)
    {
        if(pre_lo>pre_hi || in_lo>in_hi)
        {
            return null;
        }
        
        TreeNode node=new TreeNode();
        node.val=preorder[pre_lo];
        System.out.println(preorder[pre_lo]);
        int lim=hs.getOrDefault(preorder[pre_lo],0);
        int log=lim-in_lo;
        node.left=construct(pre_lo+1,pre_lo+lim,in_lo,lim-1,preorder,hs);
        node.right=construct(pre_lo+log+1,pre_hi,lim+1,in_hi ,preorder,hs);
        
        return node;
    }
}