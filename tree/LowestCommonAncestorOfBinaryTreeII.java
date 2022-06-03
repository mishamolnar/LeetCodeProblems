package LeetCode.tree;

//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-ii/
public class LowestCommonAncestorOfBinaryTreeII {
    private TreeNode LCA = null;

    //O(n) time and O(h) space
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        helper(root, p, q);
        return this.LCA;
    }

    private TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || this.LCA != null) return null;
        if (root.val == p.val && p.val == q.val) {
            this.LCA = root;
            return root;
        }
        TreeNode left = helper(root.left, p, q);
        TreeNode right = helper(root.right, p, q);
        if ((root.val == p.val || root.val == q.val) && (left != null || right != null)) {
            this.LCA = root;
            return root;
        } else if (left != null && right != null && LCA == null) {
            LCA = root;
            return root;
        } else if (root.val == p.val || root.val == q.val) {
            return root;
        } else if (left != null || right != null) {
            return left == null ? right : left;
        }
        return null;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
