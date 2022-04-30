package LeetCode.tree;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

//link - https://leetcode.com/problems/subtree-of-another-tree/
public class SubTreeOfAnotherTree {

    //searching for needed value of subroot head with bfs
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current.val == subRoot.val) {
                if (dfs(current, subRoot)) return true;
            }
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        return false;
    }

    // comparing tree with dfs
    private boolean dfs(TreeNode one, TreeNode two) {
        if (one == null && two == null) return true;
        if (one == null || two == null) return false;
        if (one.val != two.val) return false;
        return dfs(one.left, two.left) && dfs(one.right, two.right);
    }

    public static void main(String[] args) {

    }

    private static class TreeNode {
        int val;
        SubTreeOfAnotherTree.TreeNode left;
        SubTreeOfAnotherTree.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, SubTreeOfAnotherTree.TreeNode left, SubTreeOfAnotherTree.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
