class LRUCache {
    class Node{
        int val;
        int key;
        Node next=null;
        Node prev=null;

        Node(int val,int key)
        {
            this.val=val;
            this.key=key;
        }
    }
    int size;
    Node head;
    Node tail;
    HashMap<Integer,Node> hs=new HashMap<>();
    public LRUCache(int capacity) {
        this.size=capacity;
        head=new Node(-1,-1);
        tail=new Node(-1,-1);
        head.next=tail;
        tail.prev=head;
        hs=new HashMap<>();
    }
    
    public int get(int key) {
        if(hs.containsKey(key))
        {
            Node curr=hs.get(key);
            remove(curr);

            Addfirst(curr.val,curr.key);
            hs.put(key,head.next);
            return curr.val;
        }
        return -1;
    }
    void remove(Node node){
        Node m1 = node.prev;
        Node p1 = node.next;
        
        m1.next = p1;
        p1.prev = m1;
    }
    void Addfirst(int val,int key)
    {
        Node newNode=new Node(val,key);

        Node nextNode=head.next;

        head.next=newNode;
        newNode.prev=head;

        newNode.next=nextNode;
        nextNode.prev=newNode;
    }
    
    public void put(int key, int value) {
        if(hs.containsKey(key)==false)
        {
            if(hs.size()==size)
            {
                hs.remove(tail.prev.key);
                remove(tail.prev);
            }
        }
        else{
            remove(hs.get(key));
        }
        Addfirst(value,key);
        hs.put(key,head.next);
    }
}