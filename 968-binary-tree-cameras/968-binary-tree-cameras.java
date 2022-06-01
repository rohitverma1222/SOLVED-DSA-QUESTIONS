
class Solution {
    int c=0;
    final int moniter=1;
    final int camera=2;
    final int nonmonitered=3;
    
    public int minCameraCover(TreeNode root) {
        int val=helper(root);
        if(val==3)
            return c+1;
        return c;
    }
    public int helper(TreeNode root)
    {
        if(root==null)
            return 1;

        int left=helper(root.left);
        int right=helper(root.right);
        if(left==1 && right==1)
            return 3;
        else if(left==3 || right==3)
        {
            c++;
            return 2;
        }
        else 
            return 1;
    }
}