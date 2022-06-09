package LeetCode.tree;

import java.util.*;
import java.util.stream.Collectors;

//https://leetcode.com/problems/closest-binary-search-tree-value-ii/
public class ClosestBinarySearchTreeValueII {


    //deque (O(n)) time
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        inorder(root, deque, target, k);
        return new ArrayList<>(deque);
    }

    private void inorder(TreeNode current, Deque<Integer> deque, double target, int k) {
        if (current == null) return;
        inorder(current.left, deque, target, k);
        double val = (double) current.val;
        if (deque.size() == k) {
            if (Math.abs(Double.valueOf(deque.peekFirst()) - target) > Math.abs(target - val)) {
                deque.addLast(current.val);
                deque.removeFirst();
            } else return;
        } else deque.addLast(current.val);
        inorder(current.right, deque, target, k);
    }



    PriorityQueue<Integer> pq;

    //O(nlogk) approach using PQ
    public List<Integer> closestKValuesPQ(TreeNode root, double target, int k) {
        this.pq = new PriorityQueue<>((a, b) -> (int) ((Math.abs(target - b) * 1000) - (Math.abs(target - a) * 1000)));
        inorder(root, k);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(this.pq.poll());
        }
        return result;
    }

    private void inorder(TreeNode node, int k) {
        if (node == null) return;
        inorder(node.left, k);
        this.pq.add(node.val);
        if (this.pq.size() > k) pq.poll();
        inorder(node.right, k);
    }

    private static class TreeNode {
        int val;
        ClosestBinarySearchTreeValueII.TreeNode left;
        ClosestBinarySearchTreeValueII.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, ClosestBinarySearchTreeValueII.TreeNode left, ClosestBinarySearchTreeValueII.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        ClosestBinarySearchTreeValueII binarySearchTreeValueII = new ClosestBinarySearchTreeValueII();
        System.out.println(binarySearchTreeValueII.closestKValues(new TreeNode(3, new TreeNode(2, new TreeNode(1), null), new TreeNode(4)), 2, 3));
    }
}
