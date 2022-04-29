package LeetCode.tree;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//link - https://leetcode.com/problems/maximum-depth-of-binary-tree/
public class MaxDepthOfBinaryTree {

    public int maxDepthBFS(TreeNode root) {
        if (root == null) return 0;
        Queue<StackObj> queue = new LinkedList<>();
        queue.add(new StackObj(root, 1));
        int max = 1;
        while (!queue.isEmpty()) {
            StackObj curr = queue.poll();
            max = Math.max(max, curr.depth);
            if (curr.treeNode.right != null) queue.add(new StackObj(curr.treeNode.right, curr.depth + 1));
            if (curr.treeNode.left != null) queue.add(new StackObj(curr.treeNode.left, curr.depth + 1));
        }
        return max;
    }

    public int maxDepthDFS(TreeNode root) {
        if (root == null) return 0;
        Stack<StackObj> stack = new Stack<>();
        stack.add(new StackObj(root, 1));
        int max = 1;
        while (!stack.empty()) {
            StackObj curr = stack.pop();
            max = Math.max(max, curr.depth);
            if (curr.treeNode.right != null) stack.add(new StackObj(curr.treeNode.right, curr.depth + 1));
            if (curr.treeNode.left != null) stack.add(new StackObj(curr.treeNode.left, curr.depth + 1));
        }
        return max;
    }

    private class StackObj{
        TreeNode treeNode;
        int depth;

        StackObj(TreeNode treeNode, int depth) {
            this.treeNode = treeNode;
            this.depth = depth;
        }
    }

    public int maxDepthDFSRecursive(TreeNode root) {
        return 1 + Math.max(dfs(root.left), dfs(root.right));
    }

    //recursive method
    private int dfs(TreeNode node) {
        if (node == null) return 0;
        int one = dfs(node.left);
        int two = dfs(node.right);
        return 1 + Math.max(one, two);
    }

    public static void main(String[] args) {
        MaxDepthOfBinaryTree maxDepthOfBinaryTree = new MaxDepthOfBinaryTree();
        System.out.println(maxDepthOfBinaryTree.maxDepthDFS(new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4, null, new TreeNode(5, null, new TreeNode(6)))))));
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
