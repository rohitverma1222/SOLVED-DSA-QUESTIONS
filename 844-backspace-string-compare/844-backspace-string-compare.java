class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st=new Stack<>();

        for(char ch:s.toCharArray())
        {
            if(ch=='#')
            {
                if(st.size()>0)
                    st.pop();
            }
            else{
                st.push(ch);
            }
        }
        Stack<Character> stt=new Stack<>();
        for(char ch:t.toCharArray())
        {
            if(ch=='#')
            {
                if(stt.size()>0)
                    stt.pop();
            }
            else{
                stt.push(ch);
            }
        }
        if(st.equals(stt))
            return true;
        return false;
    }
}