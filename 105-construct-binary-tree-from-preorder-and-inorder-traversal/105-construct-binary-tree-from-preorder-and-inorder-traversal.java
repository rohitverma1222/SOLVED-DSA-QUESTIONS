

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
            hs.put(inorder[i],i);
        }
        return construct(preorder,hs,0,preorder.length-1,0,inorder.length-1);
    }
    public TreeNode construct(int []preorder,HashMap<Integer,Integer> hs,int pre_lo,int pre_hi,int in_lo,int in_hi)
    { 
        if(pre_lo>pre_hi || in_lo>in_hi)
            return null;

        TreeNode root=new TreeNode(preorder[pre_lo]);
        int lim=hs.get(preorder[pre_lo]);
        int log=hs.get(preorder[pre_lo])-in_lo;

        root.left=construct(preorder,hs,pre_lo+1,pre_lo+log,in_lo,lim-1);
        root.right=construct(preorder,hs,pre_lo+log+1,pre_hi,lim+1,in_hi);
        return root;
    }
    
}