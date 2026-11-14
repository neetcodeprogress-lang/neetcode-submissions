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
       //old solution too slow, try adding to list and reorder there
       if (head != null && head.next != null) {
            ArrayList<Integer> myList = new ArrayList<>();
            ListNode temp = head;
            while(temp.next != null) {
                myList.add(temp.val);
                temp = temp.next;
            }
            int n = 2;
            //reorder values
            for(int i = 1; i < myList.size(); i += 2) {
                myList.set(i, myList.size() - n);
                n++;
            }

            //now set head
            temp = head;
            n = 0;
            while (temp.next != null) {
                temp.val = myList.get(n);
                n++;
                temp = temp.next;
            }
            
       }
       


    }
}
