package LeetCode.tree;


import java.util.ArrayDeque;
import java.util.Queue;

//https://leetcode.com/problems/balanced-binary-tree/submissions/
public class BalancedBinaryTree {

    //O(n) time and space in worst case
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return getHeightMax(root, 0) != -1;
    }

    private int getHeightMax(TreeNode node, int curr) {
        if (node == null) return curr;
        int left = getHeightMax(node.left, curr + 1);
        int right = getHeightMax(node.right, curr + 1);
        if (left == -1 || right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) : -1;
    }

    private static class TreeNode {
        int val;
        BalancedBinaryTree.TreeNode left;
        BalancedBinaryTree.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, BalancedBinaryTree.TreeNode left, BalancedBinaryTree.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
