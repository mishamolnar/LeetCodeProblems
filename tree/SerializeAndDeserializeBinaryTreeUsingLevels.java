package LeetCode.tree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTreeUsingLevels {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            for (int i = q.size(); i > 0; i--) {
                TreeNode curr = q.poll();
                res.append(curr == null ? "n" : curr.val);
                res.append(" ");
                if (curr != null) {
                    q.add(curr.left);
                    q.add(curr.right);
                }
            }
            res.append("#");
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] levels = data.split("#");
        TreeNode root = null;
        Queue<TreeNode> prevLevel = new ArrayDeque<>();
        for (String level : levels) {
            String[] vals = level.split(" ");
            Queue<TreeNode> currLevel = new ArrayDeque<>();
            if (root == null) {
                root = vals[0].equals("n") ? null : new TreeNode(Integer.parseInt(vals[0]));
                if (root != null) prevLevel.add(root);
            } else {
                int pointer = 0;
                while (!prevLevel.isEmpty()) {
                    TreeNode curr = prevLevel.poll();
                    String left = vals[pointer++];
                    if (!left.equals("n")) {
                        TreeNode l = new TreeNode(Integer.parseInt(left));
                        curr.left = l;
                        currLevel.add(l);
                    }
                    String right = vals[pointer++];
                    if (!right.equals("n")) {
                        TreeNode r = new TreeNode(Integer.parseInt(right));
                        curr.right = r;
                        currLevel.add(r);
                    }
                }
                prevLevel = currLevel;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        SerializeAndDeserializeBinaryTreeUsingLevels deserializeBinaryTree = new SerializeAndDeserializeBinaryTreeUsingLevels();
        System.out.println(deserializeBinaryTree.serialize(new TreeNode(1, new TreeNode(2),
                new TreeNode(3, new TreeNode(4), new TreeNode(5)))));
        System.out.println(deserializeBinaryTree.serialize(null));
        deserializeBinaryTree.deserialize("1 #2 3 #n n 4 5 #n n n n #");
        deserializeBinaryTree.deserialize("n #");
    }


    private static class TreeNode {
        int val;
        SerializeAndDeserializeBinaryTreeUsingLevels.TreeNode left;
        SerializeAndDeserializeBinaryTreeUsingLevels.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, SerializeAndDeserializeBinaryTreeUsingLevels.TreeNode left, SerializeAndDeserializeBinaryTreeUsingLevels.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
