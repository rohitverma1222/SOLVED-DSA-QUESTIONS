class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<pair> pq=new PriorityQueue<>();

        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.size();i++)
        {
            int v=nums.get(i).get(0);
            pq.add(new pair(v,i,0));
            max=Math.max(v,max);
        }

        int rangeX=0;
        int rangeY=0;
        int rsize=Integer.MAX_VALUE;

        while(pq.size()==nums.size())
        {
            pair rem=pq.remove();

            int size=max-rem.val;
            if(rsize>size)
            {
                rangeX=rem.val;
                rangeY=max;
                rsize=size;
            }
            if(rem.idx<nums.get(rem.ln).size()-1)
            {
                rem.idx++;
                rem.val=nums.get(rem.ln).get(rem.idx);
                pq.add(rem);

                max=Math.max(max,rem.val);
            }
        }
        return new int[]{rangeX,rangeY};
    }
    class pair implements Comparable<pair>{
        int val;
        int ln;
        int idx;

        pair(int val,int ln,int idx)
        {
            this.val=val;
            this.ln=ln;
            this.idx=idx;
        }

        public int compareTo(pair other)
        {
            return this.val-other.val;
        }
    }
}