

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
    int index=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> hs=new HashMap<>();
        int t=0;
        for(int i:inorder)
        {
            hs.put(i,t++);
        }
        index=0;

        return construct(preorder,hs,0,preorder.length-1);
    }
    public TreeNode construct(int []preorder,HashMap<Integer,Integer> hs,int post_lo,int post_hi)
    {
        if(post_lo>post_hi)
            return null;

        int v=index++;
        TreeNode root=new TreeNode(preorder[v]);
        int pos=hs.get(preorder[v]);

        root.left=construct(preorder,hs,post_lo,pos-1);
        root.right=construct(preorder,hs,pos+1,post_hi);

        return root;
    }
    
}