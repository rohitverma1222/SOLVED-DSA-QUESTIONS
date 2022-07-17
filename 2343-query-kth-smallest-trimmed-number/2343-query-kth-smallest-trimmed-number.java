class Solution {
    class pair implements Comparable<pair>{
        String val;
        int idx;
        pair(String val,int idx)
        {
            this.val=val;
            this.idx=idx;
        }
        public int compareTo(pair other)
        {
            if(this.val.equals(other.val))
                return this.idx-other.idx;
            return this.val.compareTo(other.val);
        }
    }
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int []ans=new int[queries.length];
        int n= nums.length;
        // int q=queries.length;
        int idx=0;
        for(int q[]:queries)
        {
            int k=q[0];
            int trim=q[1];

            PriorityQueue<pair> pq=new PriorityQueue<>();
            for(int i=0;i<n;i++)
            {
                String str=nums[i];
                
                String val=str.substring(str.length()-trim);
                pq.add(new pair((val),i));
            }
            int a=0;
            while(k-->1)
            {
                pair rem=pq.remove();
            }
            ans[idx++]=pq.remove().idx;
        }
        return ans;
    }
}