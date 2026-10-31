class PrefixTree {

    TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode traverse = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if(traverse.children[i] == null) {
                //add it
                traverse.children[i] = new TrieNode();
            } 
            traverse = traverse.children[i];
        }

        //at this point we are at end of the word
        traverse.isEndNode = true;
    }

    public boolean search(String word) {
        TrieNode traverse = root;
        for(char c : word.toCharArray()) {
            int i = c - 'a';
            if(traverse.children[i] == null) {
                return false;
            }
            traverse = traverse.children[i];
        }
        return traverse.isEndNode;
    }

    public boolean startsWith(String prefix) {
        TrieNode traverse = root;
        for(char c : prefix.toCharArray()) {
            int i = c - 'a';
            if(traverse.children[i] == null) {
                return false;
            }
            traverse = traverse.children[i];
        }
        return true;
    }
}

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEndNode = false;
}
