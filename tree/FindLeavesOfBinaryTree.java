package LeetCode.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//https://leetcode.com/problems/find-leaves-of-binary-tree/submissions/
public class FindLeavesOfBinaryTree {
    private HashMap<Integer, ArrayList<Integer>> map;
    private int max = 0;

    //O(n) space and time
    public List<List<Integer>> findLeaves(TreeNode root) {
        map = new HashMap<>();
        helper(root);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i <= max; i++) {
            result.add(map.get(i));
        }
        return result;
    }

    private int helper(TreeNode node) {
        if (node == null) return 0;
        int curr = Math.max(helper(node.left), helper(node.right));
        max = Math.max(max, curr);
        map.putIfAbsent(curr, new ArrayList<>());
        ArrayList<Integer> level = map.get(curr);
        level.add(curr);
        return curr + 1;
    }

    private static class TreeNode {
        int val;
        FindLeavesOfBinaryTree.TreeNode left;
        FindLeavesOfBinaryTree.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, FindLeavesOfBinaryTree.TreeNode left, FindLeavesOfBinaryTree.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
