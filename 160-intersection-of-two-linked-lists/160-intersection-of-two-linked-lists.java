/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public int size(ListNode head)
    {
        if(head==null)
            return 0;
        int size=0;
        while(head!=null)
        {
            size++;
            head=head.next;
        }
        return size;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null)
            return null;
        int has=size(headA);
        int hbs=size(headB);
        
        if(has>hbs)
        {
            for(int i=0;i<has-hbs;i++)
            {
                headA=headA.next;
            }
        }
        else if(has<hbs)
        {
            for(int i=0;i<hbs-has;i++)
            {
                headB=headB.next;
            }
        }
        
        while(headA!=null && headB!=null && headA!=headB)
        {
            headA=headA.next;
            headB=headB.next;
        }
        if(headA==null || headB==null)
            return null;
        return headA;
    }
}