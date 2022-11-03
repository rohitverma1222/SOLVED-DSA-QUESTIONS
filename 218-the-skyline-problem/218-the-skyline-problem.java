class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> li=new ArrayList<>();

        for(int i=0;i<buildings.length;i++)
        {
            int x=buildings[i][0];
            int y=buildings[i][1];
            int ht=buildings[i][2];

            li.add(new int[]{x,-ht});
            li.add(new int[]{y,ht});
        }

        Collections.sort(li,(a,b)->{
            if(a[0]==b[0])
                return a[1]-b[1];
            return a[0]-b[0];
        });

        int currht=0;
        List<List<Integer>> ans=new ArrayList<>();
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        pq.add(currht);
        for(int i=0;i<li.size();i++)
        {
            int x=li.get(i)[0];
            int ht=li.get(i)[1];

            if(ht<0)
                pq.add(-ht);
            else
                pq.remove(ht);

            if(currht!=pq.peek())
            {
                List<Integer> temp=new ArrayList<>();

                temp.add(x);
                temp.add(pq.peek());

                ans.add(temp);
                currht=pq.peek();
            }
        }
        return ans;
    }
}