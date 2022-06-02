package LeetCode.tree;

//https://leetcode.com/problems/find-distance-in-a-binary-tree/
public class FindDistanceInBinaryTree {
    private int path = -1;

    public int findDistance(TreeNode root, int p, int q) {
        if (p == q) return 0;
        helper(root, p, q);
        return this.path;
    }

    //O(n) time and space
    private int helper(TreeNode root, int p, int q) {
        if (root == null) return Integer.MIN_VALUE;
        int left = helper(root.left, p, q);
        int right = helper(root.right, p , q);
        if ((root.val == p || root.val == q) && (left > 0 || right > 0)) {
            path = Math.max(left, right);
        } else if (root.val == p || root.val == q) return 1;
        if (left > 0 && right > 0 && path == -1) path = left + right;
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode three = new TreeNode(3, new TreeNode(5), new TreeNode(1, new TreeNode(0), null));
        FindDistanceInBinaryTree findDistanceInBinaryTree = new FindDistanceInBinaryTree();
        System.out.println(findDistanceInBinaryTree.findDistance(three, 0, 5));
    }

    private static class TreeNode {
        int val;
        FindDistanceInBinaryTree.TreeNode left;
        FindDistanceInBinaryTree.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, FindDistanceInBinaryTree.TreeNode left, FindDistanceInBinaryTree.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
