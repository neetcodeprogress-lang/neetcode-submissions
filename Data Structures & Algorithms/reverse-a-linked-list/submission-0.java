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
    public ListNode reverseList(ListNode head) {
        //prev as p = null, curr as c = head, temp as t = head
        ListNode p = null;
        ListNode c = head;
        ListNode t = head;
        if (head == null) {
            return head;
        }
        while(c != null) {
            t = c.next;
            c.next = p;
            p = c;
            c = t;
        }
        return p;
    }
}
