class Solution {
    public String makeGood(String s) {
        Stack<Character> st=new Stack<>();
        for(char ch:s.toCharArray())
        {
            if(st.size()>0 && (st.peek()+32==ch || st.peek()==ch+32) )
                st.pop();
            else
                st.push(ch);
        }
        String str="";
        while(st.size()!=0)
            str=(char)(st.pop())+str;
        return str;
    }
}