class MinStack {
    Stack<Long> st;
    Long min;
    public MinStack() {
        st=new Stack<>();
        min=null;
    }
    
    public void push(int val) {
        long v=val;
        if(st.size()==0)
        {
            min=v;
            st.push(v);
        }
        else if(min>=v){
            st.push(2*v-min);
            min=v;
        }
        else{
            st.push(v);
        }
        // System.out.print(min);
    }
    
    public void pop() {
        if(st.peek()<min)
        {
            min=2*min-st.peek();
            st.pop();
        }
        else{
            st.pop();
        }
    }
    
    public int top() {
        if(st.peek()>=min)
        {
            return st.peek().intValue();
        }
        else
            return min.intValue();
    }
    
    public int getMin() {
        return min.intValue();
    }
}