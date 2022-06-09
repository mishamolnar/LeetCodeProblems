package LeetCode.tree;

//https://leetcode.com/problems/closest-binary-search-tree-value/submissions/
public class ClosestBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {
        int output = root.val;
        double diff = Double.MAX_VALUE;
        while (root != null) {
            if (Math.abs(target - ((double) root.val)) < diff) {
                output = root.val;
                diff = Math.abs(target - ((double) root.val));
            }
            if (root.val > target) root = root.left;
            else root = root.right;
        }
        return output;
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
