package LeetCode.tree;

import java.util.HashMap;
import java.util.Map;

public class TreeFromPostorderAndTreeOrder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(map, inorder, postorder, 0, inorder.length - 1, 0, inorder.length - 1);
    }


    private TreeNode buildTree(Map<Integer, Integer> inorderMap, int[] inorder, int[] postorder, int postStart, int postEnd, int indorderStart, int intorderEnd)  {
        if (postStart > postEnd) {
            return null;
        } else if (postStart == postEnd) {
            return new TreeNode(postorder[postStart]);
        }
        int inorderHead = inorderMap.get(postorder[postEnd]);
        TreeNode root = new TreeNode(postorder[postEnd]);
        int rightTreeSize = intorderEnd - inorderHead + 1;
        root.left = buildTree(inorderMap, inorder, postorder, postStart, postEnd - rightTreeSize, indorderStart, inorderHead - 1);
        root.right = buildTree(inorderMap, inorder, postorder, postEnd - rightTreeSize + 1, postEnd - 1, inorderHead + 1, intorderEnd);
        return root;
    }

    private class TreeNode {
        int val;
        TreeFromPostorderAndTreeOrder.TreeNode left;
        TreeFromPostorderAndTreeOrder.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeFromPostorderAndTreeOrder.TreeNode left, TreeFromPostorderAndTreeOrder.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
