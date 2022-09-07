class MinStack {
    Stack<Long> st;
    Long min;
    public MinStack() {
        st=new Stack<>();
        min=Long.MAX_VALUE;
    }
    
    public void push(int val) {
        long v=val;
        if(st.size()==0)
        {
            st.push(v);
            min=v;
        }
        else if(v>=min)
        {
            st.push(v);
        }
        else{
            // long prev=min;
            st.push(v+v-min);
            min=v;
        }
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
        if(st.peek() >= min){
            return st.peek().intValue();
        } else {
            return min.intValue();
        }
    }
    
    public int getMin() {
        return min.intValue();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */