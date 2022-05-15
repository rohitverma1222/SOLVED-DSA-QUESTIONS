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
    int sum=0;
    public int deepestLeavesSum(TreeNode root) {
        int s=0;
        ArrayDeque<TreeNode> mq=new ArrayDeque<>();
        mq.add(root);
        ArrayDeque<TreeNode> ch=new ArrayDeque<>();
        
        while(mq.size()!=0)
        {
            TreeNode rem=mq.remove();
            
            s+=rem.val;
            
            if(rem.left!=null)
                ch.add(rem.left);
            if(rem.right!=null)
                ch.add(rem.right);
            
            if(mq.size()==0)
            {
                mq=ch;
                sum=s;
                s=0;
                ch=new ArrayDeque<>();
            }
            
        }
        return sum;
    }
}