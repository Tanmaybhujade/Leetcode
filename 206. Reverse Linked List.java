class Solution {
    private ListNode reversedHead;
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while(current != null){
			// Storing Next Node into a Temp Node.
           ListNode nextNode = current.next;
		   // At first, storing NULL value to Last Element of the Reversed List. After that adding the previous nodes to the existinng reversed LinkedList.
            current.next = prev;
            prev = current;
			// Storing the Temporary Node's value to the Current Node.
            current = nextNode;
        } 
    return prev;
    }
}
