package LeetCode.tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class MergeBsts {
    private boolean bst = true;

    public TreeNode canMerge(List<TreeNode> trees) {
        HashMap<Integer, TreeNode> roots = new HashMap<>();
        HashSet<Integer> root = new HashSet<>();
        for (TreeNode node : trees) {
            if (roots.containsKey(node.val))
                return null;
            roots.put(node.val, node);
            root.add(node.val);
        }
        for (TreeNode node : trees) {
            if (node.left != null)
                root.remove(node.left.val);
            if (node.right != null)
                root.remove(node.right.val);
        }

        if (root.size() != 1) return null;
        TreeNode res = roots.get(root.iterator().next());
        roots.remove(res.val);
        res = dfs(res, roots, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (roots.size() != 0 || !this.bst) return null;
        return res;
    }

    private TreeNode dfs(TreeNode node, HashMap<Integer, TreeNode> roots, int min, int max) {
        if (node.val <= min || node.val >= max)
            this.bst = false;
        if (node.left == null && node.right == null) {
            if (!roots.containsKey(node.val))
                return node;
            node.left = roots.get(node.val).left;
            node.right = roots.get(node.val).right;
            roots.remove(node.val);
        }
        if (node.left != null)
            dfs(node.left, roots, min, node.val);
        if (node.right != null)
            dfs(node.right, roots, node.val, max);
        return node;
    }

    private static class TreeNode {
        int val;
        MergeBsts.TreeNode left;
        MergeBsts.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, MergeBsts.TreeNode left, MergeBsts.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        MergeBsts mergeBsts = new MergeBsts();
        System.out.println(mergeBsts.canMerge(List.of(new TreeNode(2, new TreeNode(1), null),
                new TreeNode(3, new TreeNode(2), new TreeNode(5)),
                new TreeNode(5, new TreeNode(4), null))));

    }

    public boolean equalFrequency(String word) {
        char[] arr = word.toCharArray();
        for (char c : arr) {
            if (isEqual(word, c))
                return true;
        }
        return false;
    }

    private boolean isEqual(String word, char c) {
        if (!word.contains(String.valueOf(c)))
            return false;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            map.put(word.charAt(i), map.getOrDefault(word.charAt(i), 0) + 1);
        }
        map.put(c, map.get(c) - 1);
        if (map.get(c) == 0)
            map.remove(c);
        int max = map.values().stream().max(Integer::compareTo).get();
        return map.values().stream().filter(v -> v.equals(max)).count() == map.size();
    }
}
