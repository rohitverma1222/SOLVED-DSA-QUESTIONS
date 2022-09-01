class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st=new Stack<>();
        int res[]=new int[temperatures.length];
        st.push(0);
        for(int i=1;i<temperatures.length;i++)
        {
            while(st.size()>0 && temperatures[i]>temperatures[st.peek()])
            {
                int pos=st.pop();
                res[pos]=i-pos;
            }
            st.push(i);
        }

        while(st.size()>0)
        {
            res[st.pop()]=0;
        }
        return res;
    }
}