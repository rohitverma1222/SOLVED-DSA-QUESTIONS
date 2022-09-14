class Solution {
    int counter;
    public int pseudoPalindromicPaths (TreeNode root) {
        if(root==null)
            return 0;
        if(root!=null && root.left==null && root.right==null)
            return 1;
        counter=0;
        helper(root,new int[10]);
        return counter;
    }
    public void helper(TreeNode root,int []freq)
    {
        if(root==null)
        {
            return;
        }
        if(root!=null && root.left==null && root.right==null)
        {
            freq[root.val]++;
            if(check(freq))
                counter++;
            freq[root.val]--;
            return;
        }

        freq[root.val]++;
        helper(root.left,freq);
        helper(root.right,freq);
        freq[root.val]--;
    }
    public boolean check(int []ar)
    {
        boolean as=false;
        for(int i:ar)
        {
            if(i%2!=0 && as)
            {
                return false;
            }
            else if(i%2!=0)
            {
                as=true;
            }
        }
        return true;
    }
}