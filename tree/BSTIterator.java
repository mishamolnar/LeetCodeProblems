package LeetCode.tree;

import java.util.Stack;

//https://leetcode.com/problems/binary-search-tree-iterator/
public class BSTIterator {
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        addAllLeft(root);
    }

    public int next() {
        TreeNode buff = stack.pop();
        addAllLeft(buff.right);
        return buff.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void addAllLeft(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    private static class TreeNode {
        int val;
        BSTIterator.TreeNode left;
        BSTIterator.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, BSTIterator.TreeNode left, BSTIterator.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
