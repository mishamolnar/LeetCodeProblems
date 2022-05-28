package LeetCode.tree;

//https://leetcode.com/problems/binary-tree-longest-consecutive-sequence/solution/
public class BinaryTreeLongestConsecutiveSequence {
    private int result = 0;

    // O(n) time and space in worst case
    public int longestConsecutive(TreeNode root) {
        helper(root, 0);
        return result;
    }

    private void helper(TreeNode node, int curr) {
        if (node == null) return;
        if (node.right == null || node.right.val == node.val + 1) {
            helper(node.right, curr + 1);
        } else helper(node.right, 0);
        if (node.left == null || node.left.val == node.val + 1) {
            helper(node.left, curr + 1);
        } else helper(node.left, 0);
        result = Math.max(result, curr + 1);
    }

    // without storing the maxLength as a global variable
    public int longestConsecutiveWithoutGlobalWar(TreeNode root) {
        return dfs(root, null, 0);
    }

    private int dfs(TreeNode p, TreeNode parent, int length) {
        if (p == null) return length;
        length = (parent != null && p.val == parent.val + 1) ? length + 1 : 1;
        return Math.max(length, Math.max(dfs(p.left, p, length),
                dfs(p.right, p, length)));
    }

    private static class TreeNode {
        int val;
        BinaryTreeLongestConsecutiveSequence.TreeNode left;
        BinaryTreeLongestConsecutiveSequence.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, BinaryTreeLongestConsecutiveSequence.TreeNode left, BinaryTreeLongestConsecutiveSequence.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


}
