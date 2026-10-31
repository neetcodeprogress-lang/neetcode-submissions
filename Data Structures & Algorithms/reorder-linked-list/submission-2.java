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
            ArrayList<ListNode> myList = new ArrayList<>();
            ListNode temp = head;
            while(temp != null) {
                myList.add(temp);
                temp = temp.next;
            }

            //i and n represents beginning and end
            //set i.next to n
            //then set n.next to i
            //repeat
            int i = 0;
            int n = myList.size() - 1;
            while (i < n) {
                myList.get(i).next = myList.get(n);
                i++;
                myList.get(n).next = myList.get(i);
                n--;
            }

            //i now in middle representing last node, set next to null
            myList.get(i).next = null;
            
       }
    }
}
