package LeetCode.tree;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/path-sum-ii/
public class PathSumII {

    //O(n) time and space
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), 0, targetSum, root);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> curr, int currSum, int targetSum, TreeNode currNode) {
        if (currNode == null) return;
        curr.add(currNode.val);
        if (currSum + currNode.val == targetSum
                && currNode.left == null
                && currNode.right == null) {
            res.add(new ArrayList(curr));
        }
        dfs(res, curr, currSum + currNode.val, targetSum, currNode.left);
        dfs(res, curr, currSum + currNode.val, targetSum, currNode.right);
        curr.remove(curr.size() - 1);
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
