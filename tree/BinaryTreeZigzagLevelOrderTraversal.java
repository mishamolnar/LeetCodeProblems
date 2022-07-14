package LeetCode.tree;

import java.util.*;

//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while(!q.isEmpty()) {
            ArrayList<Integer> curr = new ArrayList<>();
            for (int i = q.size(); i > 0; i--) {
                TreeNode node = q.poll();
                q.add(node.left);
                q.add(node.right);
                curr.add(node.val);
            }
            if (res.size() % 2 == 1) reverseList(curr);
            res.add(curr);
        }
        return res;
    }

    private <T> void reverseList(ArrayList<T> list) {
        for (int i = 0; i < list.size() / 2; i++) {
            T buff = list.get(i);
            list.set(i, list.get(list.size() - i - 1));
            list.set(list.size() - i - 1, buff);
        }
    }

    private static class TreeNode {
        int val;
        BinaryTreeZigzagLevelOrderTraversal.TreeNode left;
        BinaryTreeZigzagLevelOrderTraversal.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, BinaryTreeZigzagLevelOrderTraversal.TreeNode left, BinaryTreeZigzagLevelOrderTraversal.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
