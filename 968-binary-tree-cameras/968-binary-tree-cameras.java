
class Solution {
    int c=0;
    class pair{
        boolean camera;
        boolean moniter;
        boolean nonmonitered;
        pair(){
            this.camera=false;
            this.moniter=true;
            this.nonmonitered=false;
        }
    }
    public int minCameraCover(TreeNode root) {
        pair get=helper(root);
        if(get.nonmonitered)
            return c+1;
        return c;
    }
    public pair helper(TreeNode root)
    {
        if(root==null)
            return new pair();

        pair left=helper(root.left);
        pair right=helper(root.right);
        pair mypair=new pair();
        if(left.moniter && right.moniter)
        {
            mypair.nonmonitered=true;
            mypair.camera=false;
            mypair.moniter=false;
        }
        else if(left.nonmonitered || right.nonmonitered)
        {
            mypair.nonmonitered=false;
            mypair.camera=true;
            c++;
            mypair.moniter=false;
        }
        else{
            mypair.nonmonitered=false;
            mypair.camera=false;
            mypair.moniter=true;
        }
        return mypair;
    }
}