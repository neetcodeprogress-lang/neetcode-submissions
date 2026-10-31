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
        ListNode iterator = l1;
        String one = "";
        String two = "";
        while (iterator != null) {
        //go through l1
            //add each value to a string
            one += "" + iterator.val;
            iterator = iterator.next;
        }

        iterator = l2;
        while (iterator != null) {
        //go through l2
            //add each value to another string
            two += "" + iterator.val;
            iterator = iterator.next;

        }

        //reverse string, get Integer.valueOf
        StringBuilder stringBuilder1 = new StringBuilder(one);
        StringBuilder stringBuilder2 = new StringBuilder(two);

        stringBuilder1.reverse();
        stringBuilder2.reverse();

        one = stringBuilder1.toString();
        two = stringBuilder2.toString();

        int num1 = Integer.valueOf(one);
        int num2 = Integer.valueOf(two);

        //add the two numbers
        int finalNum = num1 + num2;
        String finalNumString = "" + finalNum;
        System.out.println(finalNumString);

        // create a new node
        ListNode result = new ListNode();
        iterator = result;
        
        // add numbers to each node starting at end of list
        //keep going until we reach the end of the list

        for(int i = finalNumString.length() - 1; i>=0; i--) {
            iterator.val = finalNumString.charAt(i) - 48;
            System.out.println(finalNumString.charAt(i));
            System.out.println(iterator.val);
            if (i == 0) {
                iterator.next = null;
            } else {
                iterator.next = new ListNode();
            }
            iterator = iterator.next;
        }

        //then return the node
        return result;
    }
}
