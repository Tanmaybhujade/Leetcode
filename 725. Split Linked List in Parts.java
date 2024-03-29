
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        List<ListNode> l = new LinkedList<>();
        ListNode h = new ListNode(0, head);
        int c;
        ListNode t = head;
        if(head != null){
            c = 1;
            while(t.next != null){
                c++;
                t = t.next;
            }
        }else{
            c = 0;
        }
        int n = c/k;
        int n1 = c%k;
        for(int i = 0; i < n1; i++){
            t = h.next;
            l.add(t);
            for(int j = 0; j < n; j++){
                t = t.next;
            }
            h.next = t.next;
            t.next = null;
        }
        for(int i = 0; i < k-n1; i++){
            t = h.next;
            l.add(t);
            if(t != null){
                for(int j = 0; j < n-1; j++){
                    t = t.next;
                }
                h.next = t.next;
                t.next = null;
            }
        }
        return l.toArray(new ListNode[l.size()]);
    }
}
