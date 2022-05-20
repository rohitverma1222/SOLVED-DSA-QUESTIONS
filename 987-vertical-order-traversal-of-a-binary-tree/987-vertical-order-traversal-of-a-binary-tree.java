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
    class pair implements Comparable<pair>{
        TreeNode node;
        int w;
        int d;
        pair(TreeNode node,int w,int d)
        {
            this.node=node;
            this.w=w;
            this.d=d;
        }
        public int compareTo(pair other)
        {
            if(this.d==other.d)
                return this.node.val-other.node.val;
            else
                return this.d-other.d;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<pair> mq=new LinkedList<>();
        HashMap<Integer,PriorityQueue<pair>> hs=new HashMap<>();
        mq.add(new pair(root,0,1));
        int l=Integer.MAX_VALUE;
        int r=Integer.MIN_VALUE;
        while(mq.size()>0)
        {
               pair rem=mq.remove();
            
            l=Math.min(l,rem.w);
            r=Math.max(r,rem.w);
            
            if(hs.containsKey(rem.w))
            {
                hs.get(rem.w).add(rem);
            }
            else
            {
                PriorityQueue<pair> pq=new PriorityQueue<>();
                pq.add(rem);
                hs.put(rem.w,pq);
            }
            
            if(rem.node.left!=null)
            {
                mq.add(new pair(rem.node.left,rem.w-1,rem.d+1));
            }
            if(rem.node.right!=null)
            {
                mq.add(new pair(rem.node.right,rem.w+1,rem.d+1));
            }
        }
        List<List<Integer>> li=new ArrayList<>();
        for(int i=l;i<=r;i++)
        {
            List<Integer> ans=new ArrayList<>();
            PriorityQueue<pair> pq=hs.get(i);
            while(pq.size()!=0)
            {
                pair rem=pq.remove();
                ans.add(rem.node.val);
            }
            li.add(new ArrayList<>(ans));
        }
        return li;
    }
}



