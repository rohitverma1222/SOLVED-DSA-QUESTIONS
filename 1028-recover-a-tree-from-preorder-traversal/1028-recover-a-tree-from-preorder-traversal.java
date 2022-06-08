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
    int i=0;
    public TreeNode recoverFromPreorder(String tra) {
        return helper(tra,0);
    }
    public TreeNode helper(String tra,int depth)
    {
        int j=0;
        while(i+j<tra.length() && tra.charAt(i+j)=='-')
            j++;
        if(j!=depth)
            return null;
        int k=0;
        while(i+j+k<tra.length() && tra.charAt(i+j+k)!='-')
            k++;
        int val=Integer.parseInt(tra.substring(i+j,i+j+k));
        i=i+j+k;
        TreeNode root=new TreeNode(val);
        root.left=helper(tra,depth+1);
        root.right=helper(tra,depth+1);
        
        return root;
    }
}