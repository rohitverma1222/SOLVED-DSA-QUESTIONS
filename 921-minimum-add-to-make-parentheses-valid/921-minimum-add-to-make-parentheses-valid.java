class Solution {
    public int minAddToMakeValid(String s) {
        if(s.length()<=1)
            return s.length();
        Stack<Character> st=new Stack<>();

        for(char ch:s.toCharArray())
        {
            if(ch==')')
            {
                if(st.size()>0 && st.peek()=='(')
                    st.pop();
                else
                    st.push(ch);
            }
            else{
                st.push(ch);
            }
        }
        return st.size();
    }
}