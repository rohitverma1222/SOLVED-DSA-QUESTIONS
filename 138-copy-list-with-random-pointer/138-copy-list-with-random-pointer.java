/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/



class Solution {
    public Node copyRandomList(Node head) {
        if(head==null )
            return null;

        Node temp=head;
        while(temp!=null)
        {
            Node newNode=new Node(temp.val);
            
            Node p=temp.next;
            temp.next=newNode;
            newNode.next=p;
            
            temp=temp.next==null?temp.next:temp.next.next;
        }
        temp=head;
        while(temp!=null && temp.next!=null)
        {
            if(temp.random!=null)
                temp.next.random=temp.random.next;
            temp=temp.next.next;
        }
        
        Node res=head.next;
        temp=head;
        while(temp.next!=null)
        {
            Node next=temp.next;
            temp.next=temp.next.next;
            temp=next;
        }
        return res;
    }
    public void print(Node head)
    {
        Node temp=head;
        while(temp!=null)
        {
            System.out.print(temp.val+" ");
            temp=temp.next;
        }
        System.out.println();
    }
}