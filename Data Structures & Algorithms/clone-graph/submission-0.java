/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {

        if(node == null) return node;

        HashMap<Node, Node> map = new HashMap<>();

        //iterate thru; for each node

        return dfs(node, map);
    }

    //separate method to iterate
    public Node dfs(Node originalNode, HashMap<Node, Node> map) {
        if(map.containsKey(originalNode)) {
            return map.get(originalNode);
        }
        Node deepCopy = new Node(originalNode.val);
        deepCopy.val = originalNode.val;
        map.put(originalNode, deepCopy);
        for(Node node : originalNode.neighbors) {
            deepCopy.neighbors.add(dfs(node, map));
        }

        return deepCopy;
    }
}

