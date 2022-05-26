package LeetCode.tree;

//https://leetcode.com/problems/count-univalue-subtrees/
public class CountUnivalueSubtrees {
    private int count;
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) return 0;
        isUniValue(root);
        return count;
    }

    //O(n) time
    //O(h) space - так як потрібен рекурсивний стек, але не для всіх, а тільки для одної гілки до кінця
    private boolean isUniValue(TreeNode root) {
        if (root.left == null && root.right == null) {
            count++;
            return true;
        }
        boolean isCurrUniValue = true;
        if (root.left != null) {
            isCurrUniValue = isUniValue(root.left) && root.left.val == root.val;
        }
        if (root.right != null) {
            isCurrUniValue = isUniValue(root.right) && isCurrUniValue && root.right.val == root.val;
        }
        if (isCurrUniValue) count++;
        return isCurrUniValue;
    }

    private static class TreeNode {
        int val;
        CountUnivalueSubtrees.TreeNode left;
        CountUnivalueSubtrees.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, CountUnivalueSubtrees.TreeNode left, CountUnivalueSubtrees.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
