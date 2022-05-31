package LeetCode.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//https://leetcode.com/problems/boundary-of-binary-tree/solution/
public class BoundaryOfBinaryTree {

    //O(n) time and space
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<Integer> result = new ArrayList<>();
        result.add(root.val);
        addLeftBoundary(root.left, result);
        addLeaves(root.left, result);
        addLeaves(root.right, result);
        addRightBoundary(root.right, result);
        return result;
    }

    private void addLeftBoundary(TreeNode root, List<Integer> result) {
        if (root == null) return;
        if (root.left != null) {
            result.add(root.val);
            addLeftBoundary(root.left, result);
        } else if (root.right != null) {
            result.add(root.val);
            addLeftBoundary(root.right, result);
        }
    }

    private void addLeaves(TreeNode root, List<Integer> result) {
        if (root == null) return;
        addLeaves(root.left, result);
        if (root.left == null && root.right == null) result.add(root.val);
        addLeaves(root.right, result);
    }

    private void addRightBoundary(TreeNode root, List<Integer> result) {
        if (root == null || (root.left == null && root.right == null)) return;
        if (root.right != null) addRightBoundary(root.right, result);
        else addRightBoundary(root.left, result);
        result.add(root.val);
    }


    private static class TreeNode {
        int val;
        BoundaryOfBinaryTree.TreeNode left;
        BoundaryOfBinaryTree.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, BoundaryOfBinaryTree.TreeNode left, BoundaryOfBinaryTree.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
