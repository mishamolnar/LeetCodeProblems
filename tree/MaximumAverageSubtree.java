package LeetCode.tree;

//https://leetcode.com/problems/maximum-average-subtree/
public class MaximumAverageSubtree {
    private double max = 0;

    public double maximumAverageSubtree(TreeNode root) {
        helper(root);
        return max;
    }


    private int[] helper(TreeNode root) { // 0 -sum , 1 - count
        if (root == null) return new int[]{0, 0};
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int[] res = new int[]{left[0] + right[0] + root.val, 1 + left[1] + right[1]};
        max = Math.max(max, ((double) res[0] / res[1]));
        return res;
    }


    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
