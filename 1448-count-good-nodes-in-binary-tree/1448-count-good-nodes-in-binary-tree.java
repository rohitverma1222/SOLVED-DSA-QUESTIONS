class Solution {
    int c;
    public int goodNodes(TreeNode root) {
        c=0;
        helper(root,root.val);
        return c;
    }
    public void helper(TreeNode root,int max)
    {
        if(root==null)
            return;


        if(root.val>=max)
        {
            c++;
            max=root.val;
        }

        helper(root.left,max);
        helper(root.right,max);

    }
}