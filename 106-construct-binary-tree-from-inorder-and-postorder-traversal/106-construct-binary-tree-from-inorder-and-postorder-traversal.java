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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> hs=new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        {
            hs.put(inorder[i],i);
        }
        int n=inorder.length-1;
        TreeNode root=construct(0,n,0,n,postorder,hs);
        return root;
    }
    public TreeNode construct(int pre_lo,int pre_hi,int in_lo,int in_hi,int []preorder,HashMap<Integer,Integer> hs)
    {
        if(pre_lo>pre_hi || in_lo>in_hi)
        { 
            return null;
        }
        
        int idx=hs.getOrDefault(preorder[pre_hi],0);
        int log=in_hi-idx;
        TreeNode node=new TreeNode();
        node.val=preorder[pre_hi];
        node.left=construct( pre_lo,pre_hi-log-1 ,in_lo,idx-1,preorder,hs);
        node.right=construct(pre_hi-log,pre_hi-1 ,idx+1,in_hi,preorder,hs);
        
        return node;
    }
}