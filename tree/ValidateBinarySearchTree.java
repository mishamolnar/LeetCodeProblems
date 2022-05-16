package LeetCode.tree;

//link https://leetcode.com/problems/validate-binary-search-tree/submissions/
public class ValidateBinarySearchTree {

    public static void main(String[] args) {

    }

    //linear time and constant space
    public boolean isValidBST(TreeNode root) {
        return helper(root.left, Long.MIN_VALUE, root.val) && helper(root.right, root.val, Long.MAX_VALUE);
    }

    private boolean helper(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.val >= max || node.val <= min) return false;
        return helper(node.left, min, Math.min(max, node.val)) && helper(node.right, Math.max(min, node.val), max);
    }

    private static class TreeNode {
        int val;
        ValidateBinarySearchTree.TreeNode left;
        ValidateBinarySearchTree.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, ValidateBinarySearchTree.TreeNode left, ValidateBinarySearchTree.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
