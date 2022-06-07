/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    
    public String serialize(TreeNode root) {
        if(root==null)
            return "";
        StringBuilder str=new StringBuilder();
        helper(root,str);
        return str.toString();
    }
    public void helper(TreeNode root,StringBuilder str)
    {
        if(root==null)
        {
            str.append(".");
            str.append(" ");
            return;
        }
        str.append(root.val);
        str.append(" ");
        helper(root.left,str);
        helper(root.right,str);
    }
    // Decodes your encoded data to tree.
    class pair{
        TreeNode node;
        int state;
        pair(TreeNode root,int state)
        {
            this.node=root;
            this.state=state;
        }
    }
    public TreeNode deserialize(String da) {
        if(da.length()==0)
            return null;
        String data[]=da.split(" ");
        Stack<pair> st=new Stack<>();
        TreeNode root=new TreeNode(Integer.parseInt(data[0]));
        st.push(new pair(root,0));
                int idx=1;
        while(st.size()>0)
        {
            pair rem=st.peek();
            if(rem.state==0)
            {
                rem.state++;
                if(!data[idx].equals("."))
                {
                    TreeNode n=new TreeNode(Integer.parseInt(data[idx]));
                    rem.node.left=n;
                    st.push(new pair(n,0));
                }
                idx++;
            }
            else if(rem.state==1)
            {
                rem.state++;
                if(!data[idx].equals("."))
                {
                    TreeNode n=new TreeNode(Integer.parseInt(data[idx]));
                    rem.node.right=n;
                    st.push(new pair(n,0));
                }
                idx++;
            }
            else
            {
                st.pop();
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));