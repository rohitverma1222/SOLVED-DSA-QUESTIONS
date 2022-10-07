

class MyCircularQueue {
//create linkedList
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
        //Add Node at last
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
		//remove from first 
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
    }
}