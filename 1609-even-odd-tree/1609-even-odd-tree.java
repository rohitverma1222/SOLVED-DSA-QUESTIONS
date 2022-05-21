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
    public boolean isEvenOddTree(TreeNode root) {
        
        Queue<TreeNode> mq=new LinkedList<>();
        mq.add(root);
        
        int level=0;
        while(mq.size()>0)
        {
            int size=mq.size();
            int evenprev=0;
            int oddprev=Integer.MAX_VALUE;
            for(int i=0;i<size;i++)
            {
                TreeNode rem=mq.remove();
                
                if(level%2==0)
                {
                    if(rem.val%2==0)
                    {
                        System.out.println(rem.val);
                        
                        return false;
                    }
                    if(evenprev>=rem.val)
                    {
                        System.out.println(rem.val);
                        
                    return false;
                    }
                    evenprev=rem.val;
                }
                else
                {
                    if(rem.val%2!=0)
                    {
                        return false;
                    }
                    if(oddprev<=rem.val)
                    {
                        return false;
                    }
                    oddprev=rem.val;
                }
                
                if(rem.left!=null)
                    mq.add(rem.left);
                if(rem.right!=null)
                    mq.add(rem.right);
            }
            level++;
        }
        return true;
    }
}