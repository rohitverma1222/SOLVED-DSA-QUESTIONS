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
    List<List<Integer>> ans;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ans=new ArrayList<>();
        helper(root,targetSum,new ArrayList<>(),0);
        return ans;
    }
    public void helper(TreeNode root,int tar,List<Integer> li,int sum)
    {
        if(root!=null && root.left==null && root.right==null)
        {
            if(sum+root.val==tar)
            {
                li.add(root.val);
                ans.add(new ArrayList<>(li));
                li.remove(li.size()-1);
            }
            return;
        }
        if(root==null)
            return ;

        li.add(root.val);
        helper(root.left,tar,li,sum+root.val);
        li.remove(li.size()-1);
        li.add(root.val);
        helper(root.right,tar,li,sum+root.val);
        li.remove(li.size()-1);
        
        
    }
}