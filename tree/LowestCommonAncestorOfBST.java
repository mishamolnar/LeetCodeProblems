package LeetCode.tree;

public class LowestCommonAncestorOfBST {
    public static void main(String[] args) {

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val < Math.max(p.val, q.val) && root.val > Math.min(q.val, p.val)) return root;
        else if (root.val > Math.max(p.val, q.val) && root.left != null) return lowestCommonAncestor(root.left, p, q);
        else if (root.val < Math.min(q.val, p.val)) return lowestCommonAncestor(root.right, p, q);
        return root;
    }

    private static class TreeNode {
        int val;
        LowestCommonAncestorOfBST.TreeNode left;
        LowestCommonAncestorOfBST.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, LowestCommonAncestorOfBST.TreeNode left, LowestCommonAncestorOfBST.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
