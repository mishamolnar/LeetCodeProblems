package LeetCode.tree;

import java.util.LinkedList;
import java.util.Queue;

//link - https://leetcode.com/problems/same-tree/
public class SameTree {

    // DFS approach
    public boolean isSameTreeDFSRecursive(TreeNode p, TreeNode q) {
        return dfs(p, q);
    }

    // recursive solution
    public boolean dfs(TreeNode p, TreeNode q) {
        if (q == null && p == null) return true;
        if (q == null || p == null) return false;
        if (p.val != q.val) return false;
        return dfs(p.left, q.left) && dfs(p.right, q.right);
    }

    // BFS approach
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queueP = new LinkedList<>();
        Queue<TreeNode> queueQ = new LinkedList<>();
        queueP.add(p);
        queueQ.add(q);
        while (!queueP.isEmpty() || !queueQ.isEmpty()) {
            TreeNode currP = queueP.poll();
            TreeNode currQ = queueQ.poll();
            if (currP == null && currQ == null) continue;
            if (currP == null || currQ == null) return false;
            if (currP.val != currQ.val) return false;
            queueP.add(currP.left);
            queueP.add(currQ.right);
            queueQ.add(currP.left);
            queueQ.add(currQ.right);
        }
        return true;
     }

    public static void main(String[] args) {

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
