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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> mq=new LinkedList();
        mq.add(root);
            int level=0;
        while(mq.size()>0)
        {
            boolean rightnull=false;
            int s=mq.size();
            for(int i=0;i<s;i++)
            {
                TreeNode rem=mq.remove();
                boolean leftnull=true;
                if(rem.left!=null)
                {
                    if(rightnull)
                        return false;
                    leftnull=false;
                    mq.add(rem.left);
                }
                if(rem.right!=null)
                {
                    if(leftnull)
                        return false;
                    mq.add(rem.right);
                }
                else
                    rightnull=true;
            }
            int nodes=(int)Math.pow(2,level);
            level++;
            System.out.println(nodes+""+s);
            if(nodes>s && mq.size()>0)
                return false;
                
        }
        return true;
    }
}