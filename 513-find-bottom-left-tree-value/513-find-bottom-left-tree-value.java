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
    public int findBottomLeftValue(TreeNode root) {
        // ArrayList<Integer> ar=new ArrayList<>();
        int ar=0;
        if( root == null ) return ar;
        Queue<TreeNode> mq=new ArrayDeque<>();
        mq.add(root);
        while(mq.size()!=0)
        {
            int size=mq.size();
            for(int i=0;i<size;i++)
            {
                TreeNode rem=mq.remove();
                
                if(i==0)
                {
                    // ar.add(rem.data);
                    ar=rem.val;
                }
                
                if(rem.left!=null)
                {
                    mq.add(rem.left);
                }
                if(rem.right!=null)
                {
                    mq.add(rem.right);
                }
            }
        }
        return ar;
    }
}