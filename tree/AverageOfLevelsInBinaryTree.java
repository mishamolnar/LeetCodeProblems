package LeetCode.tree;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/average-of-levels-in-binary-tree/solution/
public class AverageOfLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        List<Integer> size = new ArrayList<>();
        List<Long> sum = new ArrayList<>();
        traverse(root, 0, size, sum);
        for (int i = 0; i < sum.size(); i++)
            ans.add((double) sum.get(i) / size.get(i));
        return ans;
    }

    private void traverse(TreeNode node, int level, List<Integer> size, List<Long> sum) {
        if (node == null) return;
        if (level == size.size()) {
            size.add(1);
            sum.add((long) node.val);
        } else {
            size.set(level, size.get(level) + 1);
            sum.set(level, sum.get(level) + node.val);
        }
        traverse(node.left, level + 1, size, sum);
        traverse(node.right, level + 1, size, sum);
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
