package LeetCode.sorting;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.stream.Collectors;

public class CycleSort {

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

    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        int res = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                TreeNode curr = queue.poll();
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
            List<TreeNode> list = new ArrayList<>(queue);
            res += numberOfSwaps(list);
        }
        return res;
    }

    private int numberOfSwaps(List<TreeNode> list) {
        //create a list and sort it
        //put values and indexes to hashmap
        //iterate
        List<Integer> input = list.stream().map(v -> v.val).collect(Collectors.toList());
        List<Integer> sorted = new ArrayList<>(input);
        sorted.sort(Integer::compareTo);
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < sorted.size(); i++) {
            map.put(sorted.get(i), i);
        }
        for (int i = 0; i < sorted.size(); i++) {
            if (!Objects.equals(input.get(i), sorted.get(i))) {
                res += cycleSort(input, sorted, map, i);
            }
        }
        return res;
    }

    private int cycleSort(List<Integer> list, List<Integer> sorted, HashMap<Integer, Integer> map, int index) {
        int res = 0, val = list.get(index), next = map.get(val);
        while (!Objects.equals(sorted.get(next), list.get(next))) {
            int buff = list.get(next);
            list.set(next, val);
            val = buff;
            next = map.get(val);
            res++;
        }
        return res - 1;
    }

    private void print(List<TreeNode> list) {
        System.out.println(list.stream().map(v -> String.valueOf(v.val)).reduce("", (a,b) -> a+" "+b));
    }

    public static void main(String[] args) {
        List<TreeNode> unsorted = List.of(new TreeNode(7), new TreeNode(6), new TreeNode(8), new TreeNode(5));
        List<TreeNode> sorted = List.of(new TreeNode(5), new TreeNode(6), new TreeNode(7), new TreeNode(8));
        Map<Integer, Integer> map =Map.of(5, 0, 6, 1, 7, 2, 8, 3);
        CycleSort cycleSort = new CycleSort();
//        System.out.println(cycleSort.cycleSort(unsorted, sorted, map, 0));
    }

}
