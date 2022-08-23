/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<Integer> li=new ArrayList<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<TreeNode> list=NodetoRoot(root,target);
        printkLevel(list.get(0),k,null);
        for(int i=1;i<list.size();i++)
        {
            printkLevel(list.get(i),k-i,list.get(i-1));
        }
        return li;
    }
    public void printkLevel(TreeNode root,int k,TreeNode blocker)
    {
        if(root==null || root==blocker)
            return ;
        if(k==0)
        {
            li.add(root.val);
            return ;
        }
        printkLevel(root.left,k-1,blocker);
        printkLevel(root.right,k-1,blocker);
    }
    public List<TreeNode> NodetoRoot(TreeNode root,TreeNode target)
    {
        if(root==null)
        {
            return new ArrayList<>();
        }

        if(root==target)
        {
            List<TreeNode> lis=new ArrayList<>();
            lis.add(root);
            return lis;
        }
        List<TreeNode> left=NodetoRoot(root.left,target);
        if(left.size()>0)
        {
            left.add(root);
            return left;
        }
        List<TreeNode> right=NodetoRoot(root.right,target);
        if(right.size()>0)
        {
            right.add(root);
            return right;
        }
        return new ArrayList<>();
    }
}