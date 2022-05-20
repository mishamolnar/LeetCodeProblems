package LeetCode.tree;

import java.util.*;

//https://leetcode.com/problems/binary-tree-level-order-traversal-ii/submissions/
public class BinaryTreeLevelOrderTraversalII {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> currentLevel = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                currentLevel.add(curr.val);
                if (curr.right != null) queue.add(curr.right);
                if (curr.left != null) queue.add(curr.left);
            }
            result.add(0, currentLevel);
        }
        return result;
    }


    private class TreeNode {
        int val;
        BinaryTreeLevelOrderTraversalII.TreeNode left;
        BinaryTreeLevelOrderTraversalII.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, BinaryTreeLevelOrderTraversalII.TreeNode left, BinaryTreeLevelOrderTraversalII.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
