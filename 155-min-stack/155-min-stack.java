class MinStack {
    Stack<Integer> st;
    Stack<Integer> min;
    public MinStack() {
        st=new Stack<>();
        min=new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        if(min.size()==0)
        {
            min.push(val);
        }
        else if(min.size()>0 && min.peek()>=val)
        {
            min.push(val);
        }
    }
    
    public void pop() {
        // System.out.println(st.peek()+" "+min.peek());
        if(st.peek().equals(min.peek()))
        {
            st.pop();
            min.pop();
        }
        else
            st.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min.peek();
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