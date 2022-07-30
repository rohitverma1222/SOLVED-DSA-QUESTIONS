class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));

        Stack<int[]> st=new Stack<>();

        for(int i=0;i<intervals.length;i++)
        {

            if(i==0)
            {
                st.push(intervals[i]);
            }
            else{
                int []top=st.peek();
                int curr[]=intervals[i];
                if(top[1]>curr[0])
                {
                    top[1]=Math.min(top[1],curr[1]);
                }
                else{
                    st.push(curr);
                }
            }
        }
        return intervals.length-st.size();
    }
}