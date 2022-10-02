class LRUCache {
    class Node{
        int key;
        int val;
        Node prev;
        Node next;
    }
    Node head;
    Node tail;
    int cap=0;
    HashMap<Integer,Node> hs=new HashMap<>();
    public LRUCache(int capacity) {
        this.cap=capacity;
        hs=new HashMap<>();
        head=new Node();
        tail=new Node();
        head.next=tail;
        tail.prev=head;
        
    }
    
    public int get(int key) {
        if(hs.containsKey(key)==false)
            return -1;
        else{
            Node get=hs.get(key);
            remove(get);
            Addfirst(get);
            hs.put(key,head.next);
            return head.next.val;
        }
    }
    
    public void put(int key, int value) {
        
        if(hs.containsKey(key) == false){
            if(hs.size() == cap){
                hs.remove(tail.prev.key);
                remove(tail.prev);
            }
            
            Node node = new Node();
            node.key = key;
            node.val = value;
            
            Addfirst(node);
            hs.put(key, node);
        } else {
            Node node = hs.get(key);
            
            remove(node);
            Addfirst(node);
            
            node.val = value;
        }
    }
    void Addfirst(Node node){
        Node m1 = head;
        Node p1 = head.next;
        
        node.prev = m1;
        node.next = p1;
        
        m1.next = node;
        p1.prev = node;
    }
    void remove(Node node){
        Node m1 = node.prev;
        Node p1 = node.next;
        
        m1.next = p1;
        p1.prev = m1;
    }
    
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */