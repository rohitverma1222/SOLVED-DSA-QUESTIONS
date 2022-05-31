
class Solution {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        return helper(root,limit,0);
        // return root;
    }
    public TreeNode helper(TreeNode root,int l,int sum)
    {
        if(root==null)
            return null;
        if(root.left==null && root.right==null)
        {
            if(sum+root.val<l)
                return null;
            else
                return root;
        }
        root.left=helper(root.left,l,sum+root.val);
        root.right=helper(root.right,l,sum+root.val);
        if(root.left == null && root.right == null) return null;
        return root;
    }
    
}