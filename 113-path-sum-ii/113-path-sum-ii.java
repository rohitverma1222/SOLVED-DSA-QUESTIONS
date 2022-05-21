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
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int tar) {
        helper(root,tar,new ArrayList<>());
        return ans;
    }
    public void helper(TreeNode node,int tar,List<Integer> li)
    {
        if(node==null)
            return;
        if(node.left==null && node.right==null)
        {
            li.add(node.val);
            tar-=node.val;
            if(tar==0)
                ans.add(new ArrayList<>(li));
            li.remove(li.size()-1);
            return;
        }
        li.add(node.val);
        helper(node.left,tar-node.val,li);
        helper(node.right,tar-node.val,li);
        li.remove(li.size()-1);
            
        
        
        
    }
    
}