
class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode ptr = dummy;
        Set<Integer> set = new HashSet<>();
        for (int num : nums){
            set.add(num);
        }
        while (ptr != null && ptr.next != null){
            if (set.contains(ptr.next.val)){
                ptr.next = ptr.next.next;
            } else {
                ptr = ptr.next;
            }
        }
        return dummy.next;
    }
}
