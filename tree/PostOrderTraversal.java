package LeetCode.tree;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

//link - https://leetcode.com/problems/binary-tree-postorder-traversal/
public class PostOrderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorder(root, list);
        return list;
    }

    private void postorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        postorder(root.left, list);
        postorder(root.right, list);
        list.add(root.val);
    }

    private class TreeNode {
        int val;
        PostOrderTraversal.TreeNode left;
        PostOrderTraversal.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, PostOrderTraversal.TreeNode left, PostOrderTraversal.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
