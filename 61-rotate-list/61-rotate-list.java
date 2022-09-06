/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    ListNode tail=null;
    public int size(ListNode head)
    {
        int size=0;
        while(head!=null)
        {
            tail=head;
            head=head.next;
            size++;
        }
        return size;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null )
            return head;
        ListNode curr=head;
        int size=size(curr);
        
        k=k%size;
        k=size-k;
        if(k==0)
            return head;
        
        ListNode kth=null;
        while(k!=0)
        {
            k--;
            kth=curr;
            curr=curr.next;
        }
        tail.next=head;
        ListNode newhead=kth.next;
        kth.next=null;
        return newhead;
    }
}