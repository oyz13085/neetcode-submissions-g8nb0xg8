/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;
        int val1 = 0,val2 = 0,totalValue;

        while(l1 != null || l2 != null || carry != 0){
            if(l1 == null){
                val1 = 0;
            }else{
                val1 = l1.val;
            }
            if(l2 == null){
                val2 = 0;
            }else{
                val2 = l2.val;
            }

            totalValue = val1 + val2 + carry;
            carry = totalValue / 10;
            totalValue = totalValue % 10;
            
            current.next = new ListNode(totalValue);
            current = current.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;

        } 

        return dummy.next;
        
    }
}
