class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode sam = head;
        ListNode tyra = head;
        
        while(tyra!=null && tyra.next!=null){
            sam =sam.next;
            tyra=tyra.next.next;
        }
        return sam;
    }
}
