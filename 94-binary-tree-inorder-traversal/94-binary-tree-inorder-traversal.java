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
    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode curr=root;
        List<Integer> ans=new LinkedList<>();
        
        while(curr!=null)
        {
            if(curr.left==null)
            {
                ans.add(curr.val);
                curr=curr.right;
            }
            else
            {
                TreeNode iop=curr.left;
                while(iop.right!=null && iop.right!=curr)
                {
                    iop=iop.right;
                }
                
                if(iop.right==null)
                {
                    iop.right=curr;
                    curr=curr.left;
                }
                else
                {
                    // iop.right=null;
                    ans.add(curr.val);
                    curr=curr.right;
                }
            }
        }
        return ans;
    }
}