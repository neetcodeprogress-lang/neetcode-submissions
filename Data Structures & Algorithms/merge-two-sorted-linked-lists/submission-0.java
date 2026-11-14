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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //temp node to hold on to head.next
        //return node to hold on to final head


        ListNode temp = null;
        ListNode newHead = null;
        boolean isNewIteration = true;
        while(list1 != null && list2 != null) {
            if (list2.val >= list1.val) {
                if(isNewIteration) {
                    newHead = list1;
                    isNewIteration = false;
                }
                temp = list1.next;
                list1.next = list2;
                list2 = temp;
                list1 = list1.next;
            } else { //h2 < h1
                if(isNewIteration) {
                    newHead = list2;
                    isNewIteration = false;
                }
                temp = list2.next;
                list2.next = list1;
                list1 = temp;
                list2 = list2.next;
            }
        }
        if (list1 == null && newHead == null) {
            return list2;
        } else if(list2 == null && newHead == null) {
            return list1;
        } else {
            return newHead;
        }

    }
}