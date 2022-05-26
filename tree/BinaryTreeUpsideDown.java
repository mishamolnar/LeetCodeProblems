package LeetCode.tree;

//https://leetcode.com/problems/binary-tree-upside-down/
public class BinaryTreeUpsideDown {
    public static void main(String[] args) {
        BinaryTreeUpsideDown binaryTreeUpsideDown = new BinaryTreeUpsideDown();
        binaryTreeUpsideDown.upsideDownBinaryTree(new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3)));
    }

    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) return root;
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        return newRoot;
    }

    private static class TreeNode {
        int val;
        BinaryTreeUpsideDown.TreeNode left;
        BinaryTreeUpsideDown.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, BinaryTreeUpsideDown.TreeNode left, BinaryTreeUpsideDown.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
