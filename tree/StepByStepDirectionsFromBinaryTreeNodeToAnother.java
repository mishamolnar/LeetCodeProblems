package LeetCode.tree;

import java.security.KeyStore;
import java.util.*;

//https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/submissions/
public class StepByStepDirectionsFromBinaryTreeNodeToAnother {

    public static void main(String[] args) {
        StepByStepDirectionsFromBinaryTreeNodeToAnother step = new StepByStepDirectionsFromBinaryTreeNodeToAnother();
        System.out.println(step.getDirections(new TreeNode(5, new TreeNode(1, new TreeNode(3),null), new TreeNode(2, new TreeNode(6), new TreeNode(4))), 3, 6));
    }


    //Build directions for both start and destination from the root.
    //Say we get "LLRRL" and "LRR".
    //Remove common prefix path.
    //We remove "L", and now start direction is "LRRL", and destination - "RR"
    //Replace all steps in the start direction to "U" and add destination direction.
    //The result is "UUUU" + "RR".
    public String getDirections(TreeNode root, int startValue, int destValue) {
        String start = getPath(root, startValue).reverse().toString();
        String end = getPath(root, destValue).reverse().toString();
        int left = 0;
        while (left < start.length() && left < end.length() && start.charAt(left) == end.charAt(left)) {
            left++;
        }
        char[] s = new char[start.length() - left];
        Arrays.fill(s, 'U');
        return new String(s) + end.substring(left);
    }

    private StringBuilder getPath(TreeNode node, int value) {
        if (node == null) return null;
        if (node.val == value) return new StringBuilder();
        StringBuilder left = getPath(node.left, value);
        StringBuilder right = getPath(node.right, value);
        if (left != null) return left.append("L");
        if (right != null) return right.append("R");
        return null;
    }

    //O(n) time and space
    public String getDirectionsOne(TreeNode root, int startValue, int destValue) {
        HashMap<Integer, int[]> G = new HashMap<>();
        createGraph(root, G, -1);
        Queue<Map.Entry<String, Integer>> q = new ArrayDeque<>();
        HashSet<Integer> seen = new HashSet<>();
        q.add(Map.entry("", startValue));
        seen.add(startValue);
        while (!q.isEmpty()) {
            Map.Entry<String, Integer> curr = q.poll();
            if (curr.getValue() == destValue) return curr.getKey();
            int[] neib = G.get(curr.getValue());
            if (neib[0] != -1 && !seen.contains(neib[0])) q.add(Map.entry(curr.getKey() + "U", neib[0]));
            if (neib[1] != -1 && !seen.contains(neib[1])) q.add(Map.entry(curr.getKey() + "L", neib[1]));
            if (neib[2] != -1 && !seen.contains(neib[2])) q.add(Map.entry(curr.getKey() + "R", neib[2]));
            seen.addAll(List.of(neib[0], neib[1], neib[2]));
        }
        return "";
    }

    private void createGraph(TreeNode node, HashMap<Integer, int[]> G,  int parent) {
        if (node == null) return;
        createGraph(node.left, G, node.val);
        createGraph(node.right, G, node.val);
        G.put(node.val, new int[]{parent,
                node.left == null ? -1 : node.left.val,
                node.right == null ? -1 : node.right.val});
    }


    private static class TreeNode {
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
