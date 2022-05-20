package LeetCode.tree;

import com.sun.source.tree.Tree;

import java.util.ArrayDeque;
import java.util.Queue;


//https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/submissions/
public class MaximumLevelSumOfBinaryTree {

    public int maxLevelSum(TreeNode root) {
        int maxSum = Integer.MIN_VALUE, res = 1, currRow = 1;
        if (root == null) return res;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int currSum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                currSum += node.val;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            if (currSum > maxSum) {
                res = currRow;
                maxSum = currSum;
            }
            currRow++;
        }
        return res;
    }

    private class TreeNode {
        int val;
        MaximumLevelSumOfBinaryTree.TreeNode left;
        MaximumLevelSumOfBinaryTree.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, MaximumLevelSumOfBinaryTree.TreeNode left, MaximumLevelSumOfBinaryTree.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
