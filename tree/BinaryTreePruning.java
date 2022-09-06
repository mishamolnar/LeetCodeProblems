package LeetCode.tree;

//https://leetcode.com/problems/binary-tree-pruning/
public class BinaryTreePruning {
    public TreeNode pruneTree(TreeNode root) {
        return traverse(root) ? root : null;
    }

    private boolean traverse(TreeNode root) {
        if (root == null) return false;
        boolean left = traverse(root.left);
        if (!left) root.left = null;
        boolean right = traverse(root.right);
        if (!right) root.right = null;
        return root.val == 1 || left || right;
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
