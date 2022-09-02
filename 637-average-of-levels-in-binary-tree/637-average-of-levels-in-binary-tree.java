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
    
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans=new ArrayList<>();
        Queue<TreeNode> mq=new ArrayDeque<>();
        mq.add(root);
        // q.add(new pair(root.val,0));
        Queue<TreeNode> cq=new ArrayDeque<>();
        
        long sum=0;
        int size=1;
        while(mq.size()!=0)
        {
            // size=mq.size();
            TreeNode node=mq.remove();
            sum+=node.val;
            
            if(mq.size()==0)
            {
                // System.out.println(sum+" "+size);
                double s=sum;
                double si=size;
                double a=s/si;
                
                ans.add(a);
                sum=0;
            }
            
            if(node.left!=null)
                cq.add(node.left);
            
            if(node.right!=null)
                cq.add(node.right);
            
            
            if(mq.size()==0)
            {
                size=cq.size();
                mq=cq;
                cq=new ArrayDeque<>();
            }
        }
        
        // System.out.println(ans);
        return ans;
    }
    // public void average(TreeNode node,)
}
