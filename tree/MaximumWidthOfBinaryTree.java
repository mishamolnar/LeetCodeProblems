package LeetCode.tree;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/maximum-width-of-binary-tree/submissions/
public class MaximumWidthOfBinaryTree {



    //Integer overflow solution
    public int widthOfBinaryTree(TreeNode root) {
        List<Integer> min = new ArrayList<>();
        List<Integer> max = new ArrayList<>();
        helper(root, 0, 0, min, max);
        int ans = 0;
        for (int i = 0; i < Math.min(min.size(), max.size()); i++) {
            ans = Math.max(max.get(i) - min.get(i) + 1, ans);
        }
        return ans;
    }

    private void helper(TreeNode node, int row, int position, List<Integer> min, List<Integer> max) {
        if (node == null) return;
        if (row == min.size()) min.add(position);
        else min.set(row, Math.min(position, min.get(row)));
        if (row == max.size()) max.add(position);
        else max.set(row, Math.max(max.get(row), position));
        helper(node.left, row + 1, position * 2, min, max);
        helper(node.right, row + 1, position * 2 + 1, min, max);
    }

    public static void main(String[] args) {
        TreeNode right = new TreeNode(3, new TreeNode(5), new TreeNode(3));
        TreeNode left = new TreeNode(2, new TreeNode(9), null);
        MaximumWidthOfBinaryTree maximumWidthOfBinaryTree = new MaximumWidthOfBinaryTree();
        System.out.println(maximumWidthOfBinaryTree.widthOfBinaryTree(new TreeNode(1, left, right)));
    }

    private static class TreeNode {
        int val;
        MaximumWidthOfBinaryTree.TreeNode left;
        MaximumWidthOfBinaryTree.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, MaximumWidthOfBinaryTree.TreeNode left, MaximumWidthOfBinaryTree.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
