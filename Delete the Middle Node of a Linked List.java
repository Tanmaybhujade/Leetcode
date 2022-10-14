class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if(head==null || head.next==null)
            return null;
        ListNode s=head;
        ListNode f=head;
        
        while(f!=null && f.next!=null)
        {
            s=s.next;
            f=f.next.next;
        }
        
        ListNode tmp=head;
        while(tmp.next!=s)
        {
            tmp=tmp.next;
        }
        
        tmp.next=s.next;
        return head;
    }
}
