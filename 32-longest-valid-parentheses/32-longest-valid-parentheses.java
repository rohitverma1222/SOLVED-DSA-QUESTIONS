class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st=new Stack<>();
        st.push(-1);
     int c=0;
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch==')')
            {
               st.pop();
                if(st.size()==0)
                {
                    st.push(i);
                }
                else
                {
                    c=Math.max(c,i-st.peek());
                }
            }
            else
            {
                st.push(i);
            }
        }
        return c;
    }
}