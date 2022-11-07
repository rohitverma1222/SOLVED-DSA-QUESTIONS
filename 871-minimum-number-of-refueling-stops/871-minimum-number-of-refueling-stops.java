class Solution {
        public int minRefuelStops(int target, int cur, int[][] s) {
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int i = 0, res;
        for (res = 0; cur < target; res++) {
            while (i < s.length && s[i][0] <= cur)
                pq.offer(s[i++][1]);
            if (pq.isEmpty()) return -1;
            cur += pq.poll();
        }
        return res;
    }
}