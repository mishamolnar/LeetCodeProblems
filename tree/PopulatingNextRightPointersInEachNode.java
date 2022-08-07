package LeetCode.tree;

//https://leetcode.com/problems/populating-next-right-pointers-in-each-node/submissions/
public class PopulatingNextRightPointersInEachNode {

    //O(n) constant space
    public Node connectIterative(Node root) {
        Node leftMost = root;
        while (leftMost != null) {
            Node iterator = leftMost;
            while (iterator != null) {
                if (iterator.right != null)
                    iterator.left.next = iterator.right;

                if (iterator.next != null && iterator.next.left != null)
                    iterator.right.next = iterator.next.left;

                iterator = iterator.next;
            }
            leftMost = leftMost.left;
        }

        return root;
    }


    //recursive O(n) time and O(log n) space
    public Node connect(Node root) {
        helper(root, null);
        return root;
    }

    private void helper(Node curr, Node prev) {
        if (curr == null) return;
        curr.next = prev;
        helper(curr.right, (prev == null ? null : prev.left));
        helper(curr.left, curr.right);
    }

    public static void main(String[] args) {
        PopulatingNextRightPointersInEachNode pointers = new PopulatingNextRightPointersInEachNode();
        Node left = new Node(2, new Node(4), new Node(5), null);
        Node right = new Node(3, new Node(7), new Node(7), null);
        System.out.println(pointers.connect(new Node(1, left, right, null)));
    }

    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}
