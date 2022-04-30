package LeetCode.tree;

//link - https://leetcode.com/problems/invert-binary-tree/submissions/
public class InvertBinaryTree {

    // recursive method
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode buff = root.left;
        root.left = root.right;
        root.right = buff;
        invertTree(root.left);
        invertTree(root.right);
        return root;
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
