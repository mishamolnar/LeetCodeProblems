package LeetCode.tree;

//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
public class LowestCommonAncestorOfBinaryTree {
    private TreeNode LCA = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p == q) return p;
        searchForLCA(root, p, q);
        return this.LCA;
    }

    private boolean searchForLCA(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null || LCA != null) return false;
        boolean left = searchForLCA(node.left, p, q);
        boolean right = searchForLCA(node.right, p, q);
        if (LCA != null) return false;
        if ((left && right) || ((left || right) && (node.val == p.val || node.val == q.val))) {
            LCA = node;
            return false;
        }
        return left || right || node.val == p.val || node.val == q.val;
    }


    private class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;
    }
}
