package LeetCode.tree;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SymmetricTree {

    public static void main(String[] args) {
        SymmetricTree symmetricTree = new SymmetricTree();
        System.out.println(symmetricTree.isSymmetric(new TreeNode(0, new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3))), new TreeNode(1, new TreeNode(2, new TreeNode(4), null), null))));
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return true;
        return isSymmetricHelper(root.left, root.right);
    }

    private boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
    }


    private static class TreeNode {
        int val;
        SymmetricTree.TreeNode left;
        SymmetricTree.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, SymmetricTree.TreeNode left, SymmetricTree.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
