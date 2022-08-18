class NumArray {
    class Node{
        int st;
        int ed;
        int val;
         
        Node left;
        Node right;
    }
    Node node;
    public Node construct(int []nums,int st,int ed)
    {
        if(st==ed)
        {
            Node node=new Node();
            node.st=node.ed=st;
            node.left=node.right=null;

            node.val=nums[st];
            return node;
        }
        Node node=new Node();
        int mid=(st+ed)/2;
        node.st=st;
        node.ed=ed;
        node.left=construct(nums,st,mid);
        node.right=construct(nums,mid+1,ed);

        node.val=node.left.val+node.right.val;

        return node;
    }
    public NumArray(int[] nums) {
        node=construct(nums,0,nums.length-1);
    }
    public void update(Node root,int index,int val)
    {
        if(root.st==root.ed)
        {
            root.val=val;
            return;
        }
        int mid=(root.st+root.ed)/2;
        if(index<=mid)
        {
            update(root.left,index,val);
        }
        else{
            update(root.right,index,val);
        }
        root.val=root.left.val+root.right.val;
    }
    
    public void update(int index, int val) {
        update(node,index,val);
    }
    public int query(Node root,int left,int right)
    {
        if(left>root.ed || right<root.st)
        {
            return 0;
        }
        else if(root.st>=left && root.ed<=right){
            return root.val;
        }
        else{
            int l=query(root.left,left,right);
            int r=query(root.right,left,right);
            return l+r;
        }
    }
    public int sumRange(int left, int right) {
        return query(node,left,right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */