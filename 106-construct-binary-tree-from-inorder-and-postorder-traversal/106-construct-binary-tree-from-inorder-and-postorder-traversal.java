class Solution {
    int index;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> hs=new HashMap<>();
        int t=0;
        for(int i:inorder)
        {
            hs.put(i,t++);
        }
        index=postorder.length-1;

        return construct(postorder,hs,0,postorder.length-1);
    }
    public TreeNode construct(int []postorder,HashMap<Integer,Integer> hs,int post_lo,int post_hi)
    {
        if(post_lo>post_hi)
            return null;

        int v=index--;
        TreeNode root=new TreeNode(postorder[v]);
        int pos=hs.get(postorder[v]);

        root.right=construct(postorder,hs,pos+1,post_hi);
        root.left=construct(postorder,hs,post_lo,pos-1);

        return root;
    }
}