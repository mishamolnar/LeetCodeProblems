package LeetCode.tree;
// link - https://leetcode.com/problems/binary-tree-maximum-path-sum/
public class TreeMaxPathSum {
    private int result = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxSumOfBranch(root);
        return result;
    }


    //my recursive implementation
    private int maxSumOfBranch(TreeNode root) {
        if (root == null) return 0;
        int leftSum = Math.max(maxSumOfBranch(root.left), 0);
        int rightSum = Math.max(maxSumOfBranch(root.right), 0);
        result = Math.max(result, root.val +  leftSum + rightSum);
        return root.val + Math.max(leftSum, rightSum);
    }

    public static void main(String[] args) {
        TreeMaxPathSum treeMaxPathSum = new TreeMaxPathSum();
        System.out.println(treeMaxPathSum.maxPathSum(new TreeNode(-10, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
    }

    private static class TreeNode {
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
