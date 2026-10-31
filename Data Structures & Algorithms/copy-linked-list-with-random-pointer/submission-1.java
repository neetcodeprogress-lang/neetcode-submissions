/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        if(head == null) {
            return null;
        }

        //create new head
        Node newHead = new Node(head.val);

        //create iterator nodes for newHead and head
        Node headIter = head;
        Node newHeadIter = newHead;

        //create hashmap so that we can eventually track where
        //existing new nodes are to link to random
        HashMap<Node, Node> myMap = new HashMap<>();

        //maybe iterate through head
        //create a hashmap to link old nodes to new ones
        while (headIter != null) {
            //with a iterator node
            //assign val and next
            newHeadIter.val = headIter.val;
            if (headIter.next == null) {
                newHeadIter.next = null;
            } else {
                newHeadIter.next = new Node(0);

            }

            //add to hashmap
            //          old     new
            myMap.put(headIter, newHeadIter);

            //leave random for now
            //go next
            headIter = headIter.next;
            newHeadIter = newHeadIter.next;
        }
        

        // by this point should have
        // deep copy of node val and next but not random

        //go through again to assign random to whatever head is
        //reset iterator to head again; loop

        //The way we get random is by linking the old nodes
        //to the new ones with a hashmap, where the old node(key)
        //points to the new node(val). This way we can keep
        //track of the new nodes created so that we can assign
        //random in our second iteration
        headIter = head;
        newHeadIter = newHead;

        while(headIter != null) {
            //create copy of random
            Node copy = myMap.get(headIter.random);


            newHeadIter.random = copy;

            newHeadIter = newHeadIter.next;
            headIter = headIter.next;
        }

        //finally return the new head
        return newHead;
    }
}
