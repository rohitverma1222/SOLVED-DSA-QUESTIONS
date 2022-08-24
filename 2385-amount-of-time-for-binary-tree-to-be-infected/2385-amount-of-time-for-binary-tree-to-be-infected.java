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
    int time=0;
    public void klevel(TreeNode root,int t,TreeNode block)
    {
        if(root==null|| block==root)
            return ;

        time=Math.max(t,time);

        klevel(root.left,t+1,block);
        klevel(root.right,t+1,block);
    }
    public int amountOfTime(TreeNode root, int start) {
        ArrayList<TreeNode> list=nodetoRoot(root,start);
        int t=0;
        TreeNode prev=null;
        for(int i=0;i<list.size();i++)
        {
            klevel(list.get(i),t++,prev);
            prev=list.get(i);
        }
        return time;
    }
    public ArrayList<TreeNode> nodetoRoot(TreeNode root,int target)
    {
        if(root==null)
        {
            return new ArrayList<>();
        }
        if(root.val==target)
        {
            ArrayList<TreeNode> ar=new ArrayList<>();
            ar.add(root);
            return ar;
        }

        ArrayList<TreeNode> left=nodetoRoot(root.left,target);
        if(left.size()>0)
        {
            left.add(root);
            return left;
        }

        ArrayList<TreeNode> right=nodetoRoot(root.right,target);
        if(right.size()>0)
        {
            right.add(root);
            return right;
        }
        return new ArrayList<>();
    }
}