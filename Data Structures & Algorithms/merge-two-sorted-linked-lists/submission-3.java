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
        if(list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        
        //zipper: temp node acts as merger
        ListNode merger = new ListNode();
        ListNode temp = merger; 

        while (list1 != null || list2 != null) {
            if (list1 == null) {
                merger.next = list2;
                list2 = list2.next;
                merger = merger.next;
                continue;
            } else if (list2 == null) {
                merger.next = list1;
                list1 = list1.next;
                merger = merger.next;
                continue;
            }
            if (list1.val <= list2.val) {
                //set list1 to be next
                merger.next = list1;
                list1 = list1.next;
            } else {
                //set list2 to be the next
                merger.next = list2;
                list2 = list2.next;
            }
            merger = merger.next;
        }

        return temp.next;
    }
}