class NumArray {
    class Node{
        int l;
        int h;
        int val;
        
        Node left;
        Node right;
    }
    Node root;
    public Node construct(int []nums,int lo,int hi)
    {
        if(lo==hi)
        {
            Node node=new Node();
            node.l=node.h=lo;
            node.left=node.right=null;
            node.val=nums[lo];
            return node;
        }
        int mid=(lo+hi)/2;
        Node node=new Node();
        node.l=lo;
        node.h=hi;
        node.left=construct(nums,lo,mid);
        node.right=construct(nums,mid+1,hi);

        node.val+=node.left.val;
        node.val+=node.right.val;

        return node;
    }
    public NumArray(int[] nums) {
        root=construct(nums,0,nums.length-1);
    }
    void update(Node root,int index,int val)
    {
        if(root.l==root.h)
        {
            root.val=val;
            return;
        }
        int mid=(root.l+root.h)/2;
        if(index<=mid)
        {
            update(root.left,index,val);
        }
        else{
            update(root.right,index,val);
        }

        root.val=root.left.val+root.right.val;
        return;
    }
    public void update(int index, int val) {
        update(root,index,val);
    }
    int query(Node node,int qs,int qe)
    {
        if(qs>node.h || qe<node.l)
        {
            return 0;
        }
        else if(node.l>=qs && node.h<=qe){
            return node.val;
        }
        else{
            int left=query(node.left,qs,qe);
            int right=query(node.right,qs,qe);

            return left+right;
        }
    }
    public int sumRange(int left, int right) {
        return query(root,left,right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */