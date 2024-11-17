
class Solution {
    public Node sortedInsert(Node head, int x) {
        // add your code heref
        if(head == null) {
            return new Node(x);
        }
        if(head.next == null) {
            if(head.data > x) {
                Node newone = new Node(x);
                newone.next = head;
                head.prev = newone;
                head = newone;
                return head;
            }else{
                head.next = new Node(x);
                return head;
            }
        }
        if(head.data > x) {
            Node newone = new Node(x);
            newone.next = head;
            head.prev = newone;
            head = newone;
            return head;
        }
        Node temp = head;
        while(temp.next != null && temp != null && temp.next.data < x) {
            temp = temp.next;
        }
        if(temp.next == null) {
            temp.next = new Node(x);
            return head;
        }
        Node newnode = new Node(x);
        newnode.next = temp.next;
        temp.next = newnode;
        newnode.next.prev = newnode;
        newnode.prev = temp;
        return head;
    }
}