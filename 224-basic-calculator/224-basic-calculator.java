class Solution {
    public int calculate(String s) {
        if(s.length()==0)
            return 0;
        Stack<Integer> st=new Stack<>();
        int num=0;
        int sign=1;
        int result=0;
        st.push(sign);
        
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            
            if(c>='0' && c<='9')
            {
                num=num*10+(c-'0');
            }
            else if(c=='+' || c=='-')
            {
                result+=sign*num;
                sign=st.peek()*(c=='+'?1:-1);
                num=0;
            }
            else if(c=='(')
                st.push(sign);
            else if(c==')')
                st.pop();
        }
        result+=sign*num;
        return result;
    }
}