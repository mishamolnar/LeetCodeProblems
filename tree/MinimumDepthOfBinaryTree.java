package LeetCode.tree;

import javax.swing.tree.TreeNode;
//https://leetcode.com/problems/minimum-depth-of-binary-tree/submissions/
public class MinimumDepthOfBinaryTree {

    public static void main(String[] args) {

    }

    public int minDepth(TreeNode root) {
        return helper(root, 1);
    }

    private int helper(TreeNode node, int curr) {
        if (node.left == null && node.right == null) return curr;
        int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
        if (node.left != null) left = helper(node.left, curr + 1);
        if (node.right != null) right = helper(node.right, curr + 1);
        return Math.min(right, left);
    }

    private class TreeNode {
        int val;
        MinimumDepthOfBinaryTree.TreeNode left;
        MinimumDepthOfBinaryTree.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, MinimumDepthOfBinaryTree.TreeNode left, MinimumDepthOfBinaryTree.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
