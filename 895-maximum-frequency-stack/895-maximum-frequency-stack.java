class FreqStack {
    HashMap<Integer,Integer> hs;
    HashMap<Integer,Stack<Integer>> data;
    int mf=0;
    public FreqStack() {
        hs=new HashMap<>();
        data=new HashMap<>();
        mf=0;
    }
    
    public void push(int val) {
        hs.put(val,hs.getOrDefault(val,0)+1);
        int f=hs.get(val);
        mf=Math.max(mf,hs.get(val));
        if(data.containsKey(f)==false)
        {
            data.put(f,new Stack<>());
        }
        data.get(f).push(val);
    }
    
    public int pop() {
        int val=data.get(mf).pop();
        hs.put(val,hs.get(val)-1);
        if(data.get(mf).size()==0)
        {
            data.remove(mf);
            mf--;
        }
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */