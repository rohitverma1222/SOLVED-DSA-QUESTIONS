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
   public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int carry = 0;
    ListNode p, dummy = new ListNode(0);
    p = dummy;
    while (l1 != null || l2 != null || carry != 0) {
        int res=0;
        if(l1!=null)
        {
            res+=l1.val;
            l1=l1.next;
        }
        if(l2!=null)
        {
            res+=l2.val;
            l2=l2.next;
        }
        res+=carry;
        p.next=new ListNode(res%10);
        carry=res/10;
        p=p.next;
    }
    return dummy.next;
}
    
}