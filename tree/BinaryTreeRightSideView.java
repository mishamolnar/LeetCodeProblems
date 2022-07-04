package LeetCode.tree;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/binary-tree-right-side-view/
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        reverseOrder(root, 0, results);
        return results;
    }

    private void reverseOrder(TreeNode node, int level, List<Integer> res) {
        if (node == null) return;
        if (level == res.size()) res.add(node.val);
        reverseOrder(node.right, level + 1, res);
        reverseOrder(node.left, level + 1, res);
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
