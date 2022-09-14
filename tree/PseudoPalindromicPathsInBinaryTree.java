package LeetCode.tree;

import java.util.Arrays;

public class PseudoPalindromicPathsInBinaryTree {
    public int pseudoPalindromicPaths (TreeNode root) {
        return iterate(root, new int[10]);
    }

    private int iterate(TreeNode node, int[] counts) {
        if (node == null) return 0;
        counts[node.val]++;
        if (node.left == null && node.right == null) {
            return canBePalindrome(counts) ? 1 : 0;
        }
        int left = iterate(node.left, counts.clone());
        int right = iterate(node.right, counts);
        return left + right;
    }

    private boolean canBePalindrome(int[] counts) {
        int odd = 0;
        for (int num : counts) {
            if (num % 2 == 1)
                odd++;
        }
        return odd < 2;
    }

    public static void main(String[] args) {
        PseudoPalindromicPathsInBinaryTree pathsInBinaryTree = new PseudoPalindromicPathsInBinaryTree();
        System.out.println(pathsInBinaryTree.pseudoPalindromicPaths(new TreeNode(2, new TreeNode(3,
                new TreeNode(3), new TreeNode(1)), new TreeNode(1, null, new TreeNode(1)))));
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
