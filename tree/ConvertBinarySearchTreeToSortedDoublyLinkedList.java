package LeetCode.tree;

public class ConvertBinarySearchTreeToSortedDoublyLinkedList {
    private Node first;
    private Node last;

    public Node treeToDoublyList(Node root) {
        if (root == null) return root;

        helper(root);
        last.right = first;
        first.left = last;
        return first;
    }

    //O(n) time and space complexity in worst case
    private void helper(Node node) {
        if (node != null) {
            //process left subtree
            helper(node.left);

            if (last != null) {
                // link the previous node (last)
                // with the current one (node)
                last.right = node;
                node.left = last;
            } else {
                // keep the smallest node
                first = node; //спрацьовує тільки перший раз

            }
            last = node;
            helper(node.right);
        }
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    '}';
        }
    };
}
