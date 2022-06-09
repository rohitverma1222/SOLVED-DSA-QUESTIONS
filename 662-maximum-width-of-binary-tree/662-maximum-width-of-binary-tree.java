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
    int res=Integer.MIN_VALUE;
    class pair{
        TreeNode node;
        int index;
        pair(TreeNode node,int index)
        {
            this.node=node;
            this.index=index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        ArrayDeque<pair> mq=new ArrayDeque<>();
        mq.add(new pair(root,0));
        while(mq.size()>0)
        {
            int s=mq.size();
            res=Math.max(res,(mq.getLast().index-mq.getFirst().index+1));
            for(int i=0;i<s;i++)
            {
                pair rem=mq.remove();
                
                if(rem.node.left!=null)
                    mq.add(new pair(rem.node.left,2*rem.index+1));
                
                if(rem.node.right!=null)
                    mq.add(new pair(rem.node.right,2*rem.index+2));
            }
        }
        return res;
    }
}