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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> li=new ArrayList<>();
        if(root==null)
            return li;
        Queue<TreeNode> mq=new LinkedList();
        int level=0;
        mq.add(root);
        while(mq.size()>0)
        {
            List<Integer> ar=new ArrayList<>();
            int s=mq.size();
            for(int i=0;i<s;i++)
            {
                TreeNode rem=mq.remove();
                ar.add(rem.val);
                
                if(rem.left!=null)
                    mq.add(rem.left);
                if(rem.right!=null)
                    mq.add(rem.right);
            }
            if(level%2!=0)
                Collections.reverse(ar);
            level++;
            li.add(new ArrayList<>(ar));
        }
        return li;
    }
}