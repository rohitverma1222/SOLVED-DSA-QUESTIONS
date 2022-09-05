class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> li=new ArrayList<>();
        List<Integer> l=new ArrayList<>();
        if(root==null)
            return li;
        Queue<Node> mq=new ArrayDeque<>();
        Queue<Node> cq=new ArrayDeque<>();
        mq.add(root);
        
        
        while(mq.size()!=0)
        {
            Node rem=mq.remove();
            l.add(rem.val);
            
            for(Node ch:rem.children)
            {
                cq.add(ch);
            }
            
            if(mq.size()==0)
            {
                mq=cq;
                cq=new ArrayDeque<>();
                li.add(l);
                l=new ArrayList<>();
            }
        }
        return li; 
    }
}