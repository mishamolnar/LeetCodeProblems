package LeetCode.binarySearch;

public class CountGoodNodesInBinaryTree {
    public int goodNodes(TreeNode root) {
        return traverse(root, Integer.MIN_VALUE, 0);
    }

    private int traverse(TreeNode curr, int max, int count) {
        if (curr == null)
            return count;
        if (curr.val >= max)
            count++;
        count = traverse(curr.left, Math.max(max, curr.val), count);
        return traverse (curr.right, Math.max(max, curr.val), count);
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
