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
    public ListNode reverseList(ListNode head) {
        temp=head;
        helper(head);
        return head;
    }
    ListNode temp=null;
    boolean work=true;
    public void helper(ListNode head){
        if(head==null)
            return;
        helper(head.next);
        if(work)
        {
            if(temp==head ||temp.next==head)
                work=false;
            int t=temp.val;
            temp.val=head.val;
            head.val=t;
            temp=temp.next;
        }
    }
}