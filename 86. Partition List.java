class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode ans1 = new ListNode(0);
        ListNode ans2 = new ListNode(0);
        ListNode head1 = ans1;
        ListNode head2 = ans2;
        while(head!=null){
            if(head.val<x){
                ans1.next = head;
                ans1 = ans1.next;
            }else{
                ans2.next = head;
                ans2 = ans2.next;
            }
            head = head.next;
        }
        ans1.next = head2.next;
        ans2.next = null;
        return head1.next;
    }
}
