class Solution {
    class Node{
        Node []children=new Node[2];
    }
    Node root=new Node();
    public int findMaximumXOR(int[] nums) {
        for(int n:nums)
        {   
            Node node=root;
            for(int i=31;i>=0;i--)
            {
                int bit=(n&(1<<i))==0?0:1;

                if(node.children[bit]==null)
                    node.children[bit]=new Node();
                node=node.children[bit];
            }
        }

        int res=0;
        for(int n:nums)
        {   
        int xor=0;
            Node node=root;
            for(int i=31;i>=0;i--)
            {
                int bit=(n&(1<<i))==0?0:1;

                int cbit=Math.abs(bit-1);

                if(node.children[cbit]!=null)
                {
                    xor=xor|(1<<i);
                    node=node.children[cbit];
                }
                else{
                    node=node.children[bit];
                }
            }
            res=Math.max(xor,res);
        }
        return res;
    }
}