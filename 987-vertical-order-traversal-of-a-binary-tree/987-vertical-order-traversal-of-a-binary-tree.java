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
   // class pair implements Comparable<pair>{
   //      TreeNode node;
   //      int w;
   //      int d;
   //      pair(TreeNode node,int w,int d)
   //      {
   //          this.node=node;
   //          this.w=w;
   //          this.d=d;
   //      }
   //      public int CompareTo(pair other)
   //      {
   //          if(this.d==other.d)
   //              return this.node.val-other.node.val;
   //          else
   //              return this.d-other.d;
   //      }
   //  }
    class pair implements Comparable<pair> {
        TreeNode node;
        int w;
        int d;

        pair(TreeNode node, int w, int d){
            this.node = node;
            this.w = w;
            this.d = d;
        }

        // this - other means increasing
        // other - this means decreasing
        public int compareTo(pair other){
            if(this.d == other.d){
                return this.node.val - other.node.val;
            } else {
                return this.d - other.d;
            }
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
       
        Deque<pair> ar=new LinkedList<>();
        
        ar.add(new pair(root,0,1));
        
        int l=Integer.MAX_VALUE;
        int r=Integer.MIN_VALUE;
            HashMap<Integer,PriorityQueue<pair>> hs=new HashMap<>();
        while(ar.size()>0)
        {
            pair rem=ar.remove();
            
            l=Math.min(l,rem.w);
            r=Math.max(r,rem.w);
            
            
            if(!hs.containsKey(rem.w))
            {
                PriorityQueue<pair> pq=new PriorityQueue<>();
                pq.add(rem);
                hs.put(rem.w,pq);
            }
            else
            {
                hs.get(rem.w).add(rem);
            }
            
            if(rem.node.left!=null)
            {
                ar.add(new pair(rem.node.left,rem.w-1,rem.d+1));
            }
            if(rem.node.right!=null)
            {
                ar.add(new pair(rem.node.right,rem.w+1,rem.d+1));
            }
        }
        
        List<List<Integer>> li=new ArrayList<>();
        
        for(int w=l;w<=r;w++)
        {
            List<Integer> ans=new ArrayList<>();
            PriorityQueue<pair> pp=hs.get(w);
            while(pp.size()!=0)
            {
                pair some=pp.remove();
                ans.add(some.node.val);
            }
            li.add(ans);
        }
        return li;
    }
}