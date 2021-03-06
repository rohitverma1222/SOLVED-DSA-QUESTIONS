
class Solution {
    int c=0;
    public int pathSum(TreeNode root, int tar) {
        if(root==null)
            return c;
        HashMap<Integer,Integer> hs=new HashMap<>();
        hs.put(0,1);
        helper(root,root.val,tar,hs);
        return c;
    }
    public void helper(TreeNode root,int sum,int tar,HashMap<Integer,Integer> hs)
    {
        
        if(hs.containsKey(sum-tar))
        {
            c+=hs.get(sum-tar);
        }
        hs.put(sum,hs.getOrDefault(sum,0)+1);
        
        if(root.left!=null)
        helper(root.left,sum+root.left.val,tar,hs);
        if(root.right!=null)
        helper(root.right,sum+root.right.val,tar,hs);
        
        
        if(hs.containsKey(sum) && hs.get(sum)>1)
            hs.put(sum,hs.get(sum)-1);
        else
            hs.remove(sum);
    }
   
}