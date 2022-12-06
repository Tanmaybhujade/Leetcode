class Solution {
    public ListNode oddEvenList(ListNode head) {

        if(head == null || head.next == null)
            return head;
        
        ListNode h1 = head;
        ListNode h2 = head.next;
        
        ListNode temp = head.next.next;

        ListNode t1 = h1;
        ListNode t2 = h2;
        boolean toggle = true;
        while(temp != null) {

            if(toggle) {
                t1.next = temp;
                t1 = t1.next;
            }
            else {
                t2.next = temp;
                t2 = t2.next;
            }

            temp = temp.next;
            toggle = !toggle;
        }

        t1.next = h2;
        t2.next = null;

        return h1;
    }
}
