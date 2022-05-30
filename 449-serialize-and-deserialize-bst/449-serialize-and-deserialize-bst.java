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
    String ans="";
    int index=0;
    public String serialize(TreeNode root) {
        helper(root);
        return ans;
    }
    public void helper(TreeNode root)
    {
        if(root==null)
            return ;
        // ar.add(root.val);
        ans+=root.val+"@";
        helper(root.left);
        helper(root.right);
    }
    
    public TreeNode deserialize(String data) {
        if(data.length()==0)
            return null;
        String []node=data.split("@");
        int []arr=new int[node.length];
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=Integer.parseInt(node[i]);
        }
        TreeNode n= con(arr,Integer.MAX_VALUE,Integer.MIN_VALUE);

        return n;
        
    }
    public TreeNode con(int []pre,int max,int min)
    {
        if(index==pre.length)
        {
            return null;
        }
        else if(pre[index]>min && pre[index]<max)
        {
            TreeNode node=new TreeNode();
            node.val=pre[index];
            index++;
            
            node.left=con(pre,node.val,min);
            node.right=con(pre,max,node.val);
            
            return node;
        }
        else
            return null;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;