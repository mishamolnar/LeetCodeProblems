package LeetCode.tree;

import com.sun.source.tree.Tree;

import java.util.*;

//https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/submissions/
public class AllNodesDistanceKInBinaryTree {


    //explicit graph creation
    public List<Integer> distanceKGraph(TreeNode root, TreeNode target, int k) {
        HashMap<Integer, Set<Integer>> graph = new HashMap<>();
        createGraph(root, null, graph);
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(target.val);
        visited.add(target.val);
        int steps = 0;
        while (!queue.isEmpty()) {
            if (steps == k) {
                return new ArrayList<>(queue);
            }
            for (int i = queue.size(); i > 0; i--) {
                int curr = queue.poll();
                for (Integer integer : graph.get(curr)) {
                    if (visited.contains(integer)) continue;
                    visited.add(integer);
                    queue.add(integer);
                }
            }
            steps++;
        }
        return Collections.emptyList();
    }

    private void createGraph(TreeNode node, TreeNode parent, HashMap<Integer, Set<Integer>> G) {
        if (node == null) return;
        Set<Integer> set = new HashSet<>();
        if (parent != null) set.add(parent.val);
        if (node.left != null) set.add(node.left.val);
        if (node.right != null) set.add(node.right.val);
        G.put(node.val, set);
        createGraph(node.left, node, G);
        createGraph(node.right, node, G);
    }

    //no explicit graph creation
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        BFS(result, target, k);
        searchAndCallBFS(root, target, k, result);
        return result;
    }

    private int searchAndCallBFS(TreeNode node, TreeNode target, int k, List<Integer> res) {
        if (node == null) return -1;
        if (node == target) return 0;
        int l = searchAndCallBFS(node.left, target, k, res) + 1;
        if (l > 0) {
            if (l == k) res.add(node.val);
            else if (k > l) BFS(res, node.right, k - l);
            return l >= k ? - 1 : l;
        }
        int r = searchAndCallBFS(node.right, target, k, res) + 1;
        if (r > 0) {
            if (r == k) res.add(node.val);
            else if (k > r) BFS(res, node.left, k - r);
            return r >= k ? -1 : r;
        }
        return -1;
    }


    private void BFS(List<Integer> res, TreeNode node, int remains) {
        if (node == null || remains < 0) return;
        if (remains == 0) res.add(node.val);
        BFS(res, node.left, remains - 1);
        BFS(res, node.right, remains - 1);
    }


      private static class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }
}
