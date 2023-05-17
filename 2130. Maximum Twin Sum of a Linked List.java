class Solution {
    public int pairSum(ListNode head) {
        
        ListNode slow = head, fast = head, prev = null;
        
        while (fast != null && fast.next != null) {
            ListNode temp = slow;
            slow = temp.next;
            fast = fast.next.next;
            temp.next = prev;
            prev = temp;
        }
        
        int max = 0;
        while (slow != null) {
            max = Math.max(max, prev.val+slow.val);
            slow = slow.next;
            prev = prev.next;
        }
        return max;
    }
}
