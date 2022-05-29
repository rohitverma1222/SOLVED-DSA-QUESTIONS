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
class CBTInserter {
    TreeNode ori=null;
    TreeNode root=null;
    int parent=0;
    public CBTInserter(TreeNode root) {
        this.root=root;
        this.ori=root;
    }
    
    public int insert(int val) {
        root=ori;
        helper(root,val);
        return parent;
    }
    public void helper(TreeNode root,int val)
    {
        Queue<TreeNode> mq=new LinkedList<>();
        mq.add(root);
        while(mq.size()>0)
        {
            int s=mq.size();
            for(int i=0;i<s;i++)
            {
                TreeNode rem=mq.remove();
                
                if(rem.left==null)
                {
                    parent=rem.val;
                    rem.left=new TreeNode(val);
                    return;
                }
                else if(rem.right==null)
                {
                    parent=rem.val;
                    rem.right=new TreeNode(val);
                    return;
                }
                
                if(rem.left!=null)
                {
                    mq.add(rem.left);
                }
                if(rem.right!=null)
                {
                    mq.add(rem.right);
                }
            }
        }
    }
    
    public TreeNode get_root() {
        return root;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */