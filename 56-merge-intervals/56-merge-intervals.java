class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->
            a[0]-b[0]
        );

        Stack<int[]> st=new Stack<>();

        for(int i=0;i<intervals.length;i++)
        {
            if(i==0)
            {
                st.push(intervals[i]);
            }
            else{
                int []top=st.peek();
                int []curr=intervals[i];
                if(top[1]>=curr[0])
                {
                    top[1]=Math.max(top[1],curr[1]);
                }
                else{
                    st.push(curr);
                }
            }
        }
        int [][]ans=new int[st.size()][2];
        int i=st.size()-1;
        while(st.size()!=0)
        {
            int val[]=st.pop();
            ans[i][0]=val[0];
            ans[i][1]=val[1];
            i--;
        }
        return ans;
    }
}