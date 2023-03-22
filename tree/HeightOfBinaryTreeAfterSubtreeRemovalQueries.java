package LeetCode.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HeightOfBinaryTreeAfterSubtreeRemovalQueries {

    //the idea is to maintain level of each node and the 1 max depth of nodes in each level
    //if we need to delete the node with biggest depth => then we return level + depth of the second greatest
    //if we need to delete the other node => we return level + the depth of the greatest
    //if we need to delete the only node at this level -> we return level - 1 (because we don't delete the parent node
    public int[] treeQueries(TreeNode root, int[] queries) {
        Map<Integer, Integer> levels = new HashMap<>();
        Map<Integer, int[]> depth = new HashMap<>(); //0 - node with biggest depth, 1 - depth, 2 second biggest depth node, 3 - second depth
        dfs(root, 0, levels, depth);
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int level = levels.get(queries[i]);
            int[] arr = depth.get(level);
            if (arr[0] == queries[i]) {
                res[i] = level + arr[3];
            } else {
                res[i] = level + arr[1];
            }
        }
        return res;
    }

    private int dfs(TreeNode node, int level, Map<Integer, Integer> levels, Map<Integer, int[]> depths) { //returns depth
        if (node == null) {
            return -1;
        }
        int depth = Math.max(dfs(node.left, level + 1, levels, depths), dfs(node.right, level + 1, levels, depths)) + 1;
        levels.put(node.val, level);
        depths.putIfAbsent(level, new int[]{-1, -1, -1, -1});
        int[] arr = depths.get(level);
        if (arr[1] < depth) {
            arr[2] = arr[0];
            arr[3] = arr[1];
            arr[0] = node.val;
            arr[1] = depth;
        } else if (arr[3] < depth) {
            arr[2] = node.val;
            arr[3] = depth;
        }
        depths.put(level, arr);
        return depth;
    }




    //here the idea was to have the height of each node and the parent node
    //when we delete the node then the height is -1
    //and then we go up to check how that influenced the height of parent node
    public int[] treeQueriesNlogN(TreeNode root, int[] queries) {
        Map<Integer, Integer> heights = new HashMap<>();
        Map<Integer, TreeNode> parents = new HashMap<>();
        dfs(root, heights, parents);
        int[] res = new int[queries.length];
        int rootHeight = heights.get(root.val);
        for (int i = 0; i < res.length; i++) {
            res[i] = update(queries[i], heights, parents, rootHeight);
        }
        return res;
    }

    private int update(int deleted, Map<Integer, Integer> heights, Map<Integer, TreeNode> parents, int rootHeight) {
        int height = -1;
        TreeNode parent = parents.get(deleted);
        while (parent != null) {
            int leftHeight = parent.left == null ? -1 : parent.left.val == deleted ? height : heights.get(parent.left.val);
            int rightHeight = parent.right == null ? -1 : parent.right.val == deleted ? height : heights.get(parent.right.val);
            int originalHeight = heights.get(parent.val);
            if (originalHeight == leftHeight + 1 || originalHeight == rightHeight + 1) {
                return rootHeight;
            }
            height = Math.max(leftHeight + 1, rightHeight + 1);
            deleted = parent.val;
            parent = parents.get(deleted);
        }
        return height;
    }

    private int dfs(TreeNode curr, Map<Integer, Integer> heights, Map<Integer, TreeNode> parents) {
        int height = -1;
        if (curr.left != null) {
            parents.put(curr.left.val, curr);
            height = Math.max(dfs(curr.left, heights, parents), height);
        }
        if (curr.right != null) {
            parents.put(curr.right.val, curr);
            height = Math.max(dfs(curr.right, heights, parents), height);
        }
        heights.put(curr.val, height + 1);
        return height + 1;
    }

    private static class TreeNode {
        int val;
        HeightOfBinaryTreeAfterSubtreeRemovalQueries.TreeNode left;
        HeightOfBinaryTreeAfterSubtreeRemovalQueries.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, HeightOfBinaryTreeAfterSubtreeRemovalQueries.TreeNode left, HeightOfBinaryTreeAfterSubtreeRemovalQueries.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    '}';
        }
    }
}
