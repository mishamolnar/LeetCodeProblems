package LeetCode.myImpls;

// https://leetcode.com/problems/implement-trie-prefix-tree/
public class Trie {

    private Node root;
    public Trie() {
        this.root = new Node('m', false);
    }

    public void insert(String word) {
        root = insert(word, 0, root);
    }

    private Node insert(String word, int index, Node node) {
        char c = word.charAt(index);
        if (node == null) node = new Node(c);
        if (c < node.c) node.left = insert(word, index, node.left);
        else if (c > node.c) node.right = insert(word, index, node.right);
        else if (index < word.length() - 1) node.mid = insert(word, index + 1, node.mid);
        else node.end = true;
        return node;
    }

    public boolean search(String word) {
        Node node = startsWith(word, 0, root);
        return node != null && node.end;
    }

    public boolean startsWith(String prefix) {
        Node node = startsWith(prefix, 0, root);
        return node != null;
    }

    private Node startsWith(String prefix, int index, Node node) {
        if (node == null) return null;
        char c = prefix.charAt(index);
        if (c < node.c) return startsWith(prefix, index, node.left);
        if (c > node.c) return startsWith(prefix, index, node.right);
        else if (index < prefix.length() - 1) return startsWith(prefix, index + 1, node.mid);
        else return node;
    }

    private class Node {
        private char c;
        private boolean end;
        private Node mid;
        private Node left;
        private Node right;

        public Node(char c) {
            this.c = c;
        }

        public Node(char c, boolean end) {
            this.c = c;
            this.end = end;
        }
    }
}
