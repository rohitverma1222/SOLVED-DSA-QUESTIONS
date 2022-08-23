
class Solution {
    public boolean isPalindrome(ListNode head) 
    {
        if(head==null || head.next==null)
            return true;
        ListNode fast=head;
        ListNode slow=head;

        while(fast!=null && fast.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
        }

        ListNode pre=null;
        ListNode curr=slow;
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=pre;
            pre=curr;
            curr=next;
        }
        ListNode root=head;
        while(pre!=null)
        {
            if(root.val!=pre.val)
                return false;
            root=root.next;
            pre=pre.next;
        }
        return true;
    }
}