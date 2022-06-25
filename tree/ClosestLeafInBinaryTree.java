package LeetCode.tree;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;

//https://leetcode.com/problems/closest-leaf-in-a-binary-tree/solution/
public class ClosestLeafInBinaryTree {
    public int findClosestLeaf(TreeNode root, int k) {
        HashMap<Integer, int[]> map = new HashMap<>(); //0 parent, then left and right, 3 - val
        fillMap(root, map, -1);
        Queue<int[]> queue = new ArrayDeque<>();
        HashSet<Integer> seen = new HashSet<>();
        queue.add(map.get(k));
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            if (seen.contains(curr[3])) continue;
            seen.add(curr[3]);
            if (curr[1] == 0 && curr[2] == 0) return curr[3];
            for (int i = 0; i < 3; i++) {
                if (curr[i] < 1) continue;
                queue.add(map.get(curr[i]));
            }
        }
        return -1;
    }

    private void fillMap(TreeNode root, HashMap<Integer, int[]> map, int parent) {
        if (root == null) return;
        fillMap(root.left, map, root.val);
        int[] curr = new int[4];
        curr[0] = parent;
        if (root.left != null) curr[1] = root.left.val;
        if (root.right != null) curr[2] = root.right.val;
        curr[3] = root.val;
        map.put(root.val, curr);
        fillMap(root.right, map, root.val);
    }



    public class TreeNode {
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
