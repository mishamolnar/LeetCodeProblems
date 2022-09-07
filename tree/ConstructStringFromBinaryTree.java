package LeetCode.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class ConstructStringFromBinaryTree {

    public String tree2str(TreeNode root) {
        return helper(root).toString();
    }

    private StringBuilder helper(TreeNode root) {
        if (root == null) return new StringBuilder();
        StringBuilder sb = new StringBuilder();
        sb.append(root.val)
                .append('(')
                .append(helper(root.left))
                .append(")(")
                .append(helper(root.right))
                .append(')');
        while (sb.length() > 2 && sb.substring(sb.length() - 2).equals("()"))
            sb.delete(sb.length() - 2, sb.length());
        return sb;
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
