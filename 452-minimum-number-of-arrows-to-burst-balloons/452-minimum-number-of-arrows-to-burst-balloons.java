class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b)->Integer.compare(a[0],b[0]));
        Stack<int[]> st=new Stack<>();
        for(int i=0;i<points.length;i++)
        {
            if(i==0)
            {
                st.push(points[i]);
            }
            else{
                int top[]=st.peek();
                int curr[]=points[i];

                if(top[1]>=curr[0])
                {
                    top[1]=Math.min(top[1],curr[1]);
                }
                else{
                    st.push(curr);
                }
            }
        }
        return st.size();
    }
}