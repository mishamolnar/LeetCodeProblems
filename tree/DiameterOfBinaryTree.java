package LeetCode.tree;

//https://leetcode.com/problems/diameter-of-binary-tree/submissions/
public class DiameterOfBinaryTree {
    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        longestDistance(root);
        return diameter;
    }

    private int longestDistance(TreeNode node) {
        if (node == null) return -1;
        int left = longestDistance(node.left);
        int right = longestDistance(node.right);
        diameter = Math.max(diameter, left + right);
        return Math.max(left, right) + 1;
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
