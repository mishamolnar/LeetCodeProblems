package LeetCode.tree;

import java.util.HashMap;
import java.util.Map;

public class Orders {

    public static void main(String[] args) {
        TreeNode left = new TreeNode(9, new TreeNode(4), new TreeNode(5, new TreeNode(6), null));
        TreeNode right = new TreeNode(30, new TreeNode(15), new TreeNode(7));
        TreeNode head = new TreeNode(3, left, right);
        Orders orders = new Orders();
        System.out.println(orders.preorder(head).toString());
        System.out.println(orders.inorder(head).toString());

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) inMap.put(inorder[i], i);
        return reconstruct(0, inorder.length - 1, 0, preorder, inMap);
    }


    private TreeNode reconstruct(int startIn, int endIn, int rootIndexPre, int[] preorder, Map<Integer, Integer> inMap) {
        if (startIn > endIn) return null;
        int headVal = preorder[rootIndexPre];
        int inOrderHeadIndex = inMap.get(headVal);
        TreeNode head = new TreeNode(headVal);
        head.left = reconstruct(startIn + 1, inOrderHeadIndex - 1, rootIndexPre + 1, preorder, inMap);
        head.right = reconstruct(inOrderHeadIndex + 1, inOrderHeadIndex + endIn, rootIndexPre + (inOrderHeadIndex - startIn) + 1, preorder, inMap);
        return head;
    }


    private StringBuilder preorder(TreeNode node) {
        if (node == null)
            return new StringBuilder();
        return new StringBuilder()
                .append(node.val)
                .append(" ")
                .append(preorder(node.left))
                .append(preorder(node.right))
                .append(" ");
    }

    private StringBuilder inorder(TreeNode node) {
        if (node == null)
            return new StringBuilder();
        return new StringBuilder()
                .append(inorder(node.left))
                .append(" ")
                .append(node.val)
                .append(inorder(node.right))
                .append(" ");
    }

    private  static class TreeNode {
        int val;
        Orders.TreeNode left;
        Orders.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, Orders.TreeNode left, Orders.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
