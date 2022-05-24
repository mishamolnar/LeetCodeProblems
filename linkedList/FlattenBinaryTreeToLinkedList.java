package LeetCode.linkedList;


//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/submissions/
public class FlattenBinaryTreeToLinkedList {

    public static void main(String[] args) {

    }

    public void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode buff = root.right;
        flatten(root.left);
        root.right = root.left;
        root.left = null;
        TreeNode pointer = root;
        while (pointer.right != null) pointer = pointer.right;
        flatten(buff);
        pointer.right = buff;
    }

    private void traversal(TreeNode root, TreeNode newRoot) {
        newRoot.right = root;

    }

    public static class TreeNode {
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
