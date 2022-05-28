package LeetCode.tree;

//https://leetcode.com/problems/inorder-successor-in-bst-ii/
public class InorderSuccessorInBSTII {
    //space - O(1)
    //time - O(n) worst and O(log n) average
    public Node inorderSuccessor(Node node) {
        if (node.right != null) {
            Node buff = node.right;
            while (buff.left != null) buff = buff.left;
            return buff;
        }
        Node parent = node.parent;
        while (parent != null && parent.parent != null && parent.val < node.val) parent = parent.parent;
        if (parent != null && parent.val > node.val) return parent;
        return null;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    };
}
