package LeetCode.binarySearch;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        return solve(1, n);
    }

    private List<TreeNode> solve(int start, int end) {
        if (start > end) {
            List<TreeNode> list = new ArrayList<>();
            list.add(null);
            return list;
        }
        if (start == end)
            return List.of(new TreeNode(start));

        List<TreeNode> res = new ArrayList<>();
        for (int curr = start; curr <= end; curr++) {
            List<TreeNode> left = solve(start, curr - 1);
            List<TreeNode> right = solve(curr + 1, end);
            for (TreeNode leftNode : left) {
                for (TreeNode rightNode : right) {
                    res.add(new TreeNode(curr, leftNode, rightNode));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        UniqueBinarySearchTreesII binarySearchTreesII = new UniqueBinarySearchTreesII();
        System.out.println(binarySearchTreesII.generateTrees(3));
    }
    
    
      private class TreeNode {
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
