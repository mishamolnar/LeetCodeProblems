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

    public TreeNode upsideDownBinaryTreeIterative(TreeNode root) {
        TreeNode curr = root;
        TreeNode prev = null;
        TreeNode next = null;
        TreeNode temp = null;

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


        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left.val +
                    ", right=" + right.val +
                    '}';
        }
    }
}
