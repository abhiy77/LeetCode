/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */

class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        int sum = 0,carry = 0;
        ListNode* dummy = new ListNode(0); 
        ListNode* curr = dummy;
        while(l1!=NULL && l2!=NULL){
            sum = l1->val+l2->val+carry;
            curr->next = new ListNode(sum%10);
            carry = sum/10;
            l1 = l1->next; l2 = l2->next; curr = curr->next;
        }
        
        while(l1!=NULL){
            sum = l1->val+carry;
            curr->next = new ListNode(sum%10);
            carry = sum/10;
            l1 = l1->next;curr = curr->next;
        
        }
        
        while(l2!=NULL){
            sum = l2->val+carry;
            curr->next = new ListNode(sum%10);
            carry = sum/10;
            l2 = l2->next;curr = curr->next;
        }
        if(carry > 0){
            curr->next = new ListNode(carry);
        }
         return dummy->next;
    }
   
};
