class MyCircularQueue {
    class LinkedList{
        Node head;
        Node tail;
        int size=0;
        class Node{
            int data;
            Node next;
            Node(int val)
            {
                this.data=val;
                this.next=null;
            }
        }
        
        public boolean addfirst(int val)
        {
            if(size>=cap)
                return false;
            if(size==0)
            {
                Node n=new Node(val);
                head=tail=n;
            }
            else{
                Node n=new Node(val);
                tail.next=n;
                tail=n;
            }
            size++;
            return true;
        }
        public boolean remove()
        {
            if(size==0)
                return false;
            if(size==1)
            {
                head=tail=null;
            }
            else{
                head=head.next;
            }
            size--;
            return true;
        }
        public void print()
        {
            Node temp=li.head;
            while(temp!=null)
            {
                System.out.println(temp.data);
                temp=temp.next;
            }
        }
    }
    LinkedList li=new LinkedList();
    int cap;
    public MyCircularQueue(int k) {
        cap=k;
        li.head=null;
        li.tail=null;
        li.size=0;
    }
    
    public boolean enQueue(int value) {
        return li.addfirst(value);
    }
    
    public boolean deQueue() {
        // li.print();
        return li.remove();
    }
    
    public int Front() {
        if(li.head!=null)
            return li.head.data;
        return -1;
    }
    
    public int Rear() {
        if(li.tail!=null)
        return li.tail.data;
        return -1;
    }
    
    public boolean isEmpty() {
        return li.size==0;
    }
    
    public boolean isFull() {
        return li.size==cap;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */