package LeetCode.tree;


//https://leetcode.com/problems/balanced-binary-tree/submissions/
public class BalancedBinaryTree {


    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(getHeight(root.right, 1) - getHeight(root.left, 1)) < 2;
    }

    private int getHeight(TreeNode node, int curr) {
        if (node == null) return curr;
        return Math.max(getHeight(node.left, curr + 1), getHeight(node.right, curr + 1));
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
