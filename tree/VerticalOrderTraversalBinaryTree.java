package LeetCode.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

public class VerticalOrderTraversalBinaryTree {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<Integer>> columns = new HashMap<>();
        Queue<Map.Entry<Integer, TreeNode>> row = new ArrayDeque<>();
        row.add(Map.entry(0, root));
        while (!row.isEmpty()) {
            Map<Integer, List<Integer>> curr = new HashMap<>();
            for (int i = row.size(); i > 0; i--) {
                Map.Entry<Integer, TreeNode> entry = row.poll();
                curr.putIfAbsent(entry.getKey(), new ArrayList<>());
                curr.get(entry.getKey()).add(entry.getValue().val);
                if (entry.getValue().left != null)
                    row.add(Map.entry(entry.getKey() - 1, entry.getValue().left));
                if (entry.getValue().right != null)
                    row.add(Map.entry(entry.getKey() + 1, entry.getValue().right));
            }
            for (Map.Entry<Integer, List<Integer>> entry : curr.entrySet()) {
                columns.putIfAbsent(entry.getKey(), new ArrayList<>());
                entry.getValue().sort(Comparator.naturalOrder());
                columns.get(entry.getKey()).addAll(entry.getValue());
            }
        }
        return columns
                .entrySet()
                .stream()
                .sorted((a, b) -> Integer.compare(a.getKey(), b.getKey()))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        VerticalOrderTraversalBinaryTree vertical = new VerticalOrderTraversalBinaryTree();
        System.out.println(vertical.verticalTraversal(new TreeNode(0, new TreeNode(7, null, new TreeNode(10)), new TreeNode(1, new TreeNode(2), null))));
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
