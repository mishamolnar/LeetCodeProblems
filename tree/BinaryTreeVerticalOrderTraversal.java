package LeetCode.tree;

import java.util.*;

//https://leetcode.com/problems/binary-tree-vertical-order-traversal/
public class BinaryTreeVerticalOrderTraversal {

    //O(n) time and space
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) return Collections.emptyList();
        LinkedList<List<Integer>> res =  new LinkedList<>();
        Queue<Map.Entry<TreeNode, Integer>> queue = new ArrayDeque<>();
        queue.add(Map.entry(root, 0));
        int start = 0;
        while (!queue.isEmpty()) {
            Map.Entry<TreeNode, Integer> entry = queue.poll();
            int index = start + entry.getValue();
            if (index == -1 ) res.add(0, new ArrayList<>());
            if (index == res.size()) res.add(new ArrayList<>());
            if (index == -1) start++;
            index = start + entry.getValue();
            res.get(index).add(entry.getKey().val);
            if (entry.getKey().left != null) queue.add(Map.entry(entry.getKey().left, entry.getValue() - 1));
            if (entry.getKey().right != null) queue.add(Map.entry(entry.getKey().right, entry.getValue() + 1));
        }
        return res;
    }

    public List<List<Integer>> verticalOrderTwo(TreeNode root) {
        if (root == null) return Collections.emptyList();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int left = 0, right = 0;
        Queue<Map.Entry<TreeNode, Integer>> queue = new ArrayDeque<>();
        queue.add(Map.entry(root, 0));
        while (!queue.isEmpty()) {
            Map.Entry<TreeNode, Integer> current = queue.poll();
            map.putIfAbsent(current.getValue(), new ArrayList<>());
            map.get(current.getValue()).add(current.getKey().val);
            left = Math.min(left, current.getValue());
            right = Math.max(right, current.getValue());
            if (current.getKey().left != null)
                queue.add(Map.entry(current.getKey().left, current.getValue() - 1));
            if (current.getKey().right != null)
                queue.add(Map.entry(current.getKey().right, current.getValue() + 1));
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            result.add(map.get(i));
        }
        return result;
    }

//    public List<List<Integer>> verticalOrder(TreeNode root) {
//        List<List<Integer>> output = new ArrayList();
//        if (root == null) {
//            return output;
//        }
//
//        Map<Integer, ArrayList> columnTable = new HashMap();
//        // Pair of node and its column offset
//        Queue<Pair<TreeNode, Integer>> queue = new ArrayDeque();
//        int column = 0;
//        queue.offer(new Pair(root, column));
//
//        int minColumn = 0, maxColumn = 0;
//
//        while (!queue.isEmpty()) {
//            Pair<TreeNode, Integer> p = queue.poll();
//            root = p.getKey();
//            column = p.getValue();
//
//            if (root != null) {
//                if (!columnTable.containsKey(column)) {
//                    columnTable.put(column, new ArrayList<Integer>());
//                }
//                columnTable.get(column).add(root.val);
//                minColumn = Math.min(minColumn, column);
//                maxColumn = Math.max(maxColumn, column);
//
//                queue.offer(new Pair(root.left, column - 1));
//                queue.offer(new Pair(root.right, column + 1));
//            }
//        }
//
//        for(int i = minColumn; i < maxColumn + 1; ++i) {
//            output.add(columnTable.get(i));
//        }
//
//        return output;
//    }


    public static void main(String[] args) {
        BinaryTreeVerticalOrderTraversal verticalOrderTraversal = new BinaryTreeVerticalOrderTraversal();
        TreeNode three = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(verticalOrderTraversal.verticalOrderTwo(three));
    }



    private static class TreeNode {
        int val;
        BinaryTreeVerticalOrderTraversal.TreeNode left;
        BinaryTreeVerticalOrderTraversal.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, BinaryTreeVerticalOrderTraversal.TreeNode left, BinaryTreeVerticalOrderTraversal.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
