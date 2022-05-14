package LeetCode.tree;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;


//link - https://leetcode.com/problems/binary-tree-paths/
public class BinaryTreePaths {

    public static void main(String[] args) {
        BinaryTreePaths binaryTreePaths = new BinaryTreePaths();
        System.out.println(binaryTreePaths.binaryTreePaths(new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3))));
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        inorder(root, result, new StringBuilder());
        return result;
    }

    private void inorder(TreeNode root, List<String> result, StringBuilder current) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            current.append(root.val);
            result.add(current.toString());
            return;
        }
        current.append(root.val);
        current.append("->");
        inorder(root.left, result, new StringBuilder(current));
        inorder(root.right, result, new StringBuilder(current));
    }


    private static class TreeNode {
        int val;
        BinaryTreePaths.TreeNode left;
        BinaryTreePaths.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, BinaryTreePaths.TreeNode left, BinaryTreePaths.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
