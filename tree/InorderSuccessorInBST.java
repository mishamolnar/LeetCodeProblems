package LeetCode.tree;

import javax.swing.tree.TreeNode;


//https://leetcode.com/problems/inorder-successor-in-bst/
public class InorderSuccessorInBST {
    private TreeNode prev;
    private TreeNode inorderSuccessor;

    //for BST
    public TreeNode inorderSuccessorForBST(TreeNode root, TreeNode p) {
        TreeNode successor = null;

        while (root != null) {
            if (p.val >= root.val) {
                root = root.right;
            } else {
                successor = root;
                root = root.left;
            }
        }

        return successor;
    }

    //O(n) time and space for the worst case
    //for simple binary tree
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (p.right != null) {
            TreeNode buff = p.right;
            while (buff.left != null) buff = buff.left;
            this.inorderSuccessor = buff;
        } else {
            this.inorderCase2(root, p);
        }
        return inorderSuccessor;
    }


    //по суті ми ітереруємось інордер завжди записуючи поперелню більшу (ліву) ноду
    //якщо теперішня нода дорівнює тій шо шукаємо - то попередня саксесор
    private void inorderCase2(TreeNode node, TreeNode p) {
        if (node == null) return;
        //for left side
        this.inorderCase2(node.left, p);

        // Check if previous is the inorder predecessor of node
        if (this.prev == p && this.inorderSuccessor == null) {
            this.inorderSuccessor = node;
            return;
        }

        // Keeping previous up-to-date for further recursions
        this.prev = node;

        //for right side
        this.inorderCase2(node.right, p);
    }

    //    5
    //   / \
    //  2   6
    //       \
    //        8
    //       /
    //      7
    public static void main(String[] args) {
        TreeNode seven = new TreeNode(7);
        TreeNode five = new TreeNode(5, new TreeNode(2), new TreeNode(6, null, new TreeNode(8, seven, null)));
        InorderSuccessorInBST inBST = new InorderSuccessorInBST();
        System.out.println(inBST.inorderSuccessor(five, seven).val);
    }

    private static class TreeNode {
        int val;
        InorderSuccessorInBST.TreeNode left;
        InorderSuccessorInBST.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, InorderSuccessorInBST.TreeNode left, InorderSuccessorInBST.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    '}';
        }
    }

}
