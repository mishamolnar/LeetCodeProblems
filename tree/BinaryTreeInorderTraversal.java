package LeetCode.tree;

import com.sun.source.tree.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        BinaryTreeInorderTraversal btit = new BinaryTreeInorderTraversal();
        System.out.println(btit.inorderTraversal(new TreeNode(3, new TreeNode(1, null, new TreeNode(2, null, null)),null)));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    private void helper(TreeNode node, List<Integer> list) {
        if (node == null) return;
        helper(node.left, list);
        // if (node.left == null || list.get(list.size() - 1) == node.left.val) - ця перевірка непотрібна бо якщо налл -
        // то і так не додасться, а через те що рекурсія перед додаванням - все буде по порядку
        list.add(node.val);
        helper(node.right, list);
    }

    private static class TreeNode {
        int val;
        BinaryTreeInorderTraversal.TreeNode left;
        BinaryTreeInorderTraversal.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, BinaryTreeInorderTraversal.TreeNode left, BinaryTreeInorderTraversal.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
