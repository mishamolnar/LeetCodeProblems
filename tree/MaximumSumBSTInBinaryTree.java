package LeetCode.tree;

import com.sun.source.tree.Tree;

//https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/submissions/
public class MaximumSumBSTInBinaryTree {
    private int maxSum = 0;

    public int maxSumBST(TreeNode root) {
        helper(root);
        return maxSum;
    }

    /*
    * if root is not bst - retuns null
    * returns int[] if bst
    * int[0] min value in bst
    * int[1] max value in bst
    * int[2] sum f all values in bst
    */
    private int[] helper(TreeNode root) {
        if (root == null) return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        if (!(left != null  //якщо все виконується - то ми не повертємо налл, якщо хоч одне фейлиться - повертаємо налл
                && right != null
                && root.val >= left[1]
                && root.val <= right[0])) return null;
        int min = Math.min(left[0], root.val);
        int max = Math.max(right[1], root.val);
        int sum = root.val + left[2] + right[2];
        maxSum = Math.max(sum, maxSum);
        return new int[] {min, max, sum};
    }


    public static void main(String[] args) {
        MaximumSumBSTInBinaryTree maximumSumBSTInBinaryTree = new MaximumSumBSTInBinaryTree();
//        TreeNode left = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(6, new TreeNode(5), new TreeNode(7)));
//        TreeNode right = new TreeNode(12, new TreeNode(10, new TreeNode(9), new TreeNode(11)), new TreeNode(14, new TreeNode(13), new TreeNode(15)));
//        System.out.println(maximumSumBSTInBinaryTree.maxSumBST(new TreeNode(6, left, right)));
        //        TreeNode left = new TreeNode(4, new TreeNode(2), new TreeNode(4));
//        TreeNode right = new TreeNode(3, new TreeNode(2), new TreeNode(5, new TreeNode(4), new TreeNode(6)));
//        System.out.println(maximumSumBSTInBinaryTree.maxSumBST(new TreeNode(1, left, right))); // -- 20
        System.out.println(maximumSumBSTInBinaryTree.maxSumBST(new TreeNode(1, null, new TreeNode(10, new TreeNode(-5), new TreeNode(20)))));
        //System.out.println(maximumSumBSTInBinaryTree.maxSumBST(new TreeNode(4, new TreeNode(3, new TreeNode(1), new TreeNode(2)), null)));
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
