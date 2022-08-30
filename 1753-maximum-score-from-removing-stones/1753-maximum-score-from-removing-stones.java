class Solution {
    public int maximumScore(int a, int b, int c) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        pq.add(a);
        pq.add(b);
        pq.add(c);
        
        int cc=0;
        while(pq.size()>1)
        {
            int aa=pq.remove();
            int ba=pq.remove();
            if(aa-1>0)
            pq.add(aa-1);
            if(ba-1>0)
            pq.add(ba-1);
            cc++;
        }
        return cc;
    }
}