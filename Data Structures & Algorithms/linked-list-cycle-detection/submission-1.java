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
    public boolean hasCycle(ListNode head) {
        //throw each node into a hashset?
        //if curr.next already exists in hashset return true?
        HashSet<ListNode> mySet = new HashSet<>();

        while(head != null && head.next != null) {
        
            mySet.add(head);
            head = head.next;
            if (mySet.contains(head.next)) {
                return true;
            }
        }

        return false;
    }
}
