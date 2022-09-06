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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null )
            return head;
        ListNode curr=head;
        int size=0;
        ListNode kth=null;
        ListNode tail=null;
        while(curr!=null)
        {
            size++;
            tail=curr;
            curr=curr.next;
        }
        curr=head;
        k=k%size;
        k=size-k;
        if(k==0)
            return head;
        while(k!=0)
        {
            k--;
            kth=curr;
            curr=curr.next;
        }
        System.out.println(kth.val);
        
        tail.next=head;
        ListNode newhead=kth.next;
        kth.next=null;
        return newhead;
    }
    // }
}