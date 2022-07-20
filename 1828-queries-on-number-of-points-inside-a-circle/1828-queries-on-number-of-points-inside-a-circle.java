class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int ans[]=new int[queries.length];
            int idx=0;
        for(int q[]:queries)
        {
            int x1=q[0];
            int y1=q[1];
            int radius=q[2];
            int c=0;
            for(int p[]:points)
            {
                int x2=p[0];
                int y2=p[1];

                int dis=((int)(Math.pow(x1-x2,2))+(int)(Math.pow(y1-y2,2)));

                if(dis<=(radius*radius))
                    c++;
            }
        System.out.println(c);
            ans[idx++]=c;
        }
        return ans;
    }
}