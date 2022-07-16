package LeetCode.tree;

import java.util.HashMap;


//https://leetcode.com/problems/path-sum-iii/
public class PathSumIII {
    private int counter = 0;
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        helper(root, map, 0L, targetSum);
        return counter;
    }

    private void helper(TreeNode node, HashMap<Long, Integer> prevSums, Long currSum, int targetSum) {
        if (node == null) return;
        currSum += node.val;
        counter += prevSums.getOrDefault(currSum - targetSum, 0);
        prevSums.put(currSum, prevSums.getOrDefault(currSum, 0) + 1);
        helper(node.left, prevSums, currSum, targetSum);
        helper(node.right, prevSums, currSum, targetSum);
        prevSums.put(currSum, prevSums.getOrDefault(currSum, 0) - 1);
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
