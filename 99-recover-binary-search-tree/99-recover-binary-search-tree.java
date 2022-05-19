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
    static TreeNode prev;
    static TreeNode fn,sn;
    public void recoverTree(TreeNode root) {
        prev=sn=fn=null;
        helper(root);
        
        int t=fn.val;
        fn.val=sn.val;
        sn.val=t;
    }
    public void helper(TreeNode root){
        TreeNode curr=root;
        
        while(curr!=null)
        {
            if(curr.left==null)
            {
                if(prev!=null && prev.val>=curr.val)
                {
                    if(sn==null)
                    {
                        fn=prev;
                    }
                    sn=curr;
                }
                prev=curr;
                curr=curr.right;
            }
            else
            {
                TreeNode iop=curr.left;
                while(iop.right!=null && iop.right!=curr)
                    iop=iop.right;
                
                if(iop.right==null)
                {
                    iop.right=curr;
                    curr=curr.left;
                }
                else
                {
                   if(prev!=null && prev.val>=curr.val)
                    {
                    if(sn==null)
                    {
                        fn=prev;
                    }
                    sn=curr;
                    }
                prev=curr;
                    iop.right=null;
                    curr=curr.right;
                }
            }
        }
    }
}



