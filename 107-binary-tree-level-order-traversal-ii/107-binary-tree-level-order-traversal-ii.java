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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> mq=new LinkedList<>();
        mq.add(root);
        List<List<Integer>> li=new ArrayList<>();
        if(root==null)
            return li;
        while(mq.size()>0)
        {
            List<Integer> ans=new ArrayList<>();
            int s=mq.size();
            for(int i=0;i<s;i++)
            {
                TreeNode rem=mq.remove();
                
                ans.add(rem.val);
                
                if(rem.left!=null)
                    mq.add(rem.left);
                if(rem.right!=null)
                    mq.add(rem.right);
            }
            li.add(new ArrayList<>(ans));
        }
        Collections.reverse(li);
        return li;
    }
}