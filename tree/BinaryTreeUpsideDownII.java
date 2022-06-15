package LeetCode.tree;

public class BinaryTreeUpsideDownII {

    public static void main(String[] args) {
        BinaryTreeUpsideDownII binaryTreeUpsideDown = new BinaryTreeUpsideDownII();
        binaryTreeUpsideDown.upsideDownBinaryTree(new BinaryTreeUpsideDownII.TreeNode(1, new BinaryTreeUpsideDownII.TreeNode(2, new BinaryTreeUpsideDownII.TreeNode(4), new BinaryTreeUpsideDownII.TreeNode(5)), new BinaryTreeUpsideDownII.TreeNode(3)));
    }

    public TreeNode upsideDownBinaryTreeIterative(TreeNode root) {
        TreeNode curr = root;
        TreeNode next = null;
        TreeNode temp = null;
        TreeNode prev = null;

        while (curr != null) {
            next = curr.left;

            curr.left = temp;
            temp = curr.right;
            curr.right = prev;

            prev = curr;
            curr = next;
        }

        return prev;
    }

    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null) return root;

        TreeNode newRoot = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right  = root;
        root.left = null;
        root.right = null;
        return newRoot;
    }

    private static class TreeNode {
        int val;
        BinaryTreeUpsideDownII.TreeNode left;
        BinaryTreeUpsideDownII.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, BinaryTreeUpsideDownII.TreeNode left, BinaryTreeUpsideDownII.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
