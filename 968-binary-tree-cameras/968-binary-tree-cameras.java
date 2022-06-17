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
    class pair{
        boolean camera;
        boolean moniter;
        boolean non_moniter;
        pair(){
            
        }
        pair(boolean camera,boolean moniter,boolean non_moniter)
        {
            this.camera=camera;
            this.moniter=moniter;
            this.non_moniter=non_moniter;
        }
    }
    int c=0;
    public int minCameraCover(TreeNode root) {
        if(root==null)
            return 0;
        if(root!=null && root.right==null && root.left==null)
            return 1;
        pair get=helper(root);
        if(get.non_moniter==true)
            return c+1;
        return c;
    }
    public pair helper(TreeNode root)
    {
        if(root==null)
        {
            return new pair(false,true,false);
        }

        pair left=helper(root.left);
        pair right=helper(root.right);
        pair newPair=new pair();
        if(left.non_moniter==true || right.non_moniter==true)
        {
            newPair.non_moniter=false;
            newPair.camera=true;
            newPair.moniter=false;
            c++;
        }
        else if(left.moniter==true && right.moniter==true)
        {
            newPair.non_moniter=true;
            newPair.camera=false;
            newPair.moniter=false;
        }
        else{
            newPair.non_moniter=false;
            newPair.camera=false;
            newPair.moniter=true;
        }
        return newPair;
    }
}