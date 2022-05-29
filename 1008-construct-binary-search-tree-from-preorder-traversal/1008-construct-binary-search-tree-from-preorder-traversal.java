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
        int max;
        int min;
        TreeNode node;
        int state;
        pair(int max,int min,TreeNode node,int state)
        {
            this.max=max;
            this.min=min;
            this.node=node;
            this.state=state;
        }
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        Stack<pair> st=new Stack<>();
        TreeNode root1=new TreeNode(preorder[0]);
        int i=1;
        st.push(new pair(Integer.MAX_VALUE,Integer.MIN_VALUE,root1,0));
        while(st.size()>0 && i<preorder.length)
        {
            pair top=st.peek();
            TreeNode root=null;
              
                root=new TreeNode(preorder[i]);
                
            
            if(top.state==0  )
            {
                if(root.val>top.min && root.val<top.node.val)
                {
                    top.node.left=root;
                    st.push(new pair(top.node.val,top.min,root,0 ));
                    i++;
                }
                top.state++;
            }
            else if(top.state==1 )
            {
                if(root.val>top.node.val && root.val<top.max)
                {
                    top.node.right=root;
                    st.push(new pair(top.max,top.node.val,root,0));
                    i++;
                }
                top.state++;
            }
            else
            {
                st.pop();
            }
        }
    return root1;
    }
}