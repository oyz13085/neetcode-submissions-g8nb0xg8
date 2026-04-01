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
    public void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        if(head==null || head.next==null) return;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode startList2 = slow.next;
        ListNode startList1 = head;
        
        slow.next = null;
        ListNode endList1 = slow;
        

        //Reversing the second list
        ListNode current = startList2;
        ListNode prev = null;
        ListNode next = null;

        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        ListNode tmp1, tmp2;
        while(prev != null){
            tmp1 = startList1.next;
            tmp2 = prev.next;

            startList1.next = prev;
            prev.next = tmp1;

            startList1 = tmp1;
            prev = tmp2;
        }
    }
}
