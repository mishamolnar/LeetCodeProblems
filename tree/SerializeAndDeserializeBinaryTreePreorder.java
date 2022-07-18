package LeetCode.tree;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTreePreorder {
    private static final String NULL = "n";
    private static final String DELIMITER = " ";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode node, StringBuilder construct) {
        if (node == null) {
            construct.append(NULL).append(DELIMITER);
            return;
        } else construct.append(node.val).append(DELIMITER);
        serialize(node.left, construct);
        serialize(node.right, construct);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q = new ArrayDeque<>(Arrays.asList(data.split(DELIMITER)));
        return deserialize(q);
    }

    private TreeNode deserialize(Queue<String> q) {
        String curr = q.poll();
        if (curr.equals(NULL)) return null;
        TreeNode node = new TreeNode(Integer.parseInt(curr));
        node.left = deserialize(q);
        node.right = deserialize(q);
        return node;
    }

    private static class TreeNode {
        int val;
        SerializeAndDeserializeBinaryTreePreorder.TreeNode left;
        SerializeAndDeserializeBinaryTreePreorder.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, SerializeAndDeserializeBinaryTreePreorder.TreeNode left, SerializeAndDeserializeBinaryTreePreorder.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public static void main(String[] args) {
        SerializeAndDeserializeBinaryTreePreorder deserializeBinaryTree = new SerializeAndDeserializeBinaryTreePreorder();
        System.out.println(deserializeBinaryTree.serialize(new SerializeAndDeserializeBinaryTreePreorder.TreeNode(1, new SerializeAndDeserializeBinaryTreePreorder.TreeNode(2),
                new SerializeAndDeserializeBinaryTreePreorder.TreeNode(3, new SerializeAndDeserializeBinaryTreePreorder.TreeNode(4), new SerializeAndDeserializeBinaryTreePreorder.TreeNode(5)))));
        System.out.println(deserializeBinaryTree.serialize(null));
        deserializeBinaryTree.deserialize("1 2 n n 3 4 n n 5 n n ");
        deserializeBinaryTree.deserialize("n");
    }
}
