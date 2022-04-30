package LeetCode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeTree {

    // encodes tree to 1 2 3 n n 4 5 6 n n n n n from new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4, new TreeNode(6), null), new TreeNode(5))))
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return "";
        StringBuilder result = new StringBuilder();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = queue.poll();
                if (curr == null) {
                    result.append("n");
                    result.append(" ");
                    continue;
                }
                result.append(curr.val);
                result.append(" ");
                queue.add(curr.left);
                queue.add(curr.right);
            }
        }
        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(" ");
        if (data.length() == 0) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        queue.add(root);
        for (int i = 1; i < nodes.length; i++) {
            TreeNode curr = queue.poll();
            if (curr == null) continue;
            if (!nodes[i].equals("n")) {
                TreeNode left = new TreeNode(Integer.parseInt(nodes[i]));
                curr.left = left;
                queue.add(left);
            }
            if (!nodes[++i].equals("n")) { // ++1 increments immediately, not after
                TreeNode right = new TreeNode(Integer.parseInt(nodes[i]));
                curr.right = right;
                queue.add(right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        SerializeDeserializeTree serializeDeserializeTree = new SerializeDeserializeTree();
        System.out.println(serializeDeserializeTree.serialize(new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4, new TreeNode(6), null), new TreeNode(5)))));
        serializeDeserializeTree.deserialize("1 2 3 n n 4 5 6 n n n n n");
    }

    private static class TreeNode {
        int val;
        SerializeDeserializeTree.TreeNode left;
        SerializeDeserializeTree.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, SerializeDeserializeTree.TreeNode left, SerializeDeserializeTree.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
