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
        // go through list, add to arraylist
        ListNode temp = head;
        ArrayList<Integer> myList = new ArrayList<>();
        while (temp != null) {
            myList.add(temp.val);
            temp = temp.next;
        }
        // try to remove the n indice from the end
        int indiceToRemove = myList.size() - n;
        //if valid remove?
        myList.remove(indiceToRemove); // set to number outside of val constraint range
        //if not valid do nothing

        //reassign back to head, return head
        temp = head;
        for(int i = 0; i < myList.size(); i++) {
            temp.val = myList.get(i);
            if (i + 1 >= myList.size()) {
                temp.next = null;
            } else {
                temp = temp.next;
            }
        }

        return head;
        
    }
}
