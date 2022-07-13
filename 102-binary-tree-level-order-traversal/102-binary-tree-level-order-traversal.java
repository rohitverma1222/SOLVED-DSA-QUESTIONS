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
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null)
            return ans;
        Queue<TreeNode> mq=new LinkedList<>();
        mq.add(root);
        mq.add(null);
        List<Integer> li=new ArrayList<>();
        while(mq.size()>0)
        {
            
            TreeNode rem=mq.remove();
            
            if(rem==null)
            {
                ans.add(new ArrayList<>(li));
                li=new ArrayList<>();
                if(mq.size()>=1)
                mq.add(null);
                continue;
            }
            li.add(rem.val);
            
            if(rem.left!=null)
            {
                mq.add(rem.left);
            }
            if(rem.right!=null)
            {
                mq.add(rem.right);
            }
        }
        return ans;
    }
}