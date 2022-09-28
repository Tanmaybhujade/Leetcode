class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        int sz=0;
        ListNode* temp=head;
        while(temp){
            sz++;
            temp=temp->next;
        }
        if(!(sz^n))return head->next;
        n=sz-n-1;
        temp=head;
        while(n-->0)temp=temp->next;
        temp->next=temp->next->next;
        
        return head;
    }
};
