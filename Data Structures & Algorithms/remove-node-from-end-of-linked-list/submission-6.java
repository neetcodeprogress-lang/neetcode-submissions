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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }
        //trying out neetcode solution from memory based off of what I udnerstand

        ListNode dummy = new ListNode(0, head);
        ListNode l = dummy;
        ListNode r = head;
        for(int i = 0; i < n; i++) {
            r = r.next;
        }

        //pointers are at their position, now go until right = null
        while (r != null) {
            l = l.next;
            r = r.next;
        }

        //l is now at position to reassign next to next.next
        //r should be null
        l.next = l.next.next;

        return dummy.next;
    }
}
