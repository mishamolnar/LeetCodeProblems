package LeetCode.tree;


import java.util.HashMap;
import java.util.Map;


//link - https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
public class ConstructTreeFromTreInOrder {
    public static void main(String[] args) {
        ConstructTreeFromTreInOrder constructTreeFromTreInOrder = new ConstructTreeFromTreInOrder();
        TreeNode root = constructTreeFromTreInOrder.buildTree(new int[]{3,1,2,4}, new int[]{1,2,3,4});
        System.out.println("catdog".substring(3, 6));
    }

    public TreeNode buildTreeTwo(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        return buildTreeInBoundary(preorder, 0, inorder.length - 1, 0, map);
    }

    private TreeNode buildTreeInBoundary(int[] preorder, int inStart, int inEnd, int rootIndexPre, HashMap<Integer, Integer> inorder) {
        if (inStart > inEnd) return null;
        int rootVal = preorder[rootIndexPre];
        int rootIndexIn = inorder.get(rootVal);
        TreeNode left = buildTreeInBoundary(preorder, inStart, rootIndexIn - 1, rootIndexPre + 1, inorder);
        TreeNode right = buildTreeInBoundary(preorder, rootIndexIn + 1, inEnd, rootIndexPre + rootIndexIn - inStart + 1, inorder);
        return new TreeNode(rootVal, left, right);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> in = new HashMap<>();
        for (int i = 0; i < preorder.length; i++) {
            in.put(inorder[i], i);
        }
        return splitTree(preorder, in, 0, inorder.length - 1, 0);
    }

    private TreeNode splitTree(int[] preorder, Map<Integer, Integer> in, int inStart, int inEnd, int rootIndexPreorder) { //rootIndexPreorder - зазвичай перший індекс в піддереві
        if (inEnd < inStart) return null;
        int rootVal = preorder[rootIndexPreorder], rootIndexInorder = in.get(rootVal); // rootIndexInorder - зазвичай перший індекс в піддереві
        TreeNode root = new TreeNode(rootVal);
        root.left = splitTree(preorder, in, inStart, rootIndexInorder - 1, rootIndexPreorder + 1);
        root.right = splitTree(preorder, in, rootIndexInorder + 1, inEnd, rootIndexPreorder + rootIndexInorder - inStart + 1);
        // (rootIndexPreorder + rootIndexInorder - inStart + 1) - визначаємо перший індекс в преодер
        return root;
    }

    private static class TreeNode {
        int val;
        ConstructTreeFromTreInOrder.TreeNode left;
        ConstructTreeFromTreInOrder.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, ConstructTreeFromTreInOrder.TreeNode left, ConstructTreeFromTreInOrder.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
