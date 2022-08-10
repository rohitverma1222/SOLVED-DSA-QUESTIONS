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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==1)
            return new TreeNode(nums[0]);
        return helper(nums,0,nums.length-1);
    }
    public TreeNode helper(int []nums,int l,int h)
    {
        if(l>h)
            return null;


        int mid=(l+h)/2;

        TreeNode Node=new TreeNode(nums[mid]);
        Node.left=helper(nums,l,mid-1);
        Node.right=helper(nums,mid+1,h);

        return Node;
    }
}