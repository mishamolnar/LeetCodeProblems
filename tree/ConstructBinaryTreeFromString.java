package LeetCode.tree;

//https://leetcode.com/problems/construct-binary-tree-from-string/
public class ConstructBinaryTreeFromString {
    int currStart = 0;

    public TreeNode str2tree(String s) {
        return helper(s);
    }

    // O(h) space and O(n) time
    private TreeNode helper(String s) {
        if (currStart >= s.length()) return null;
        if (s.charAt(currStart) == '(') currStart++;
        if (s.charAt(currStart) == ')') {
            ++currStart;
            return null;
        }
        TreeNode curr = new TreeNode(readDigit(s));
        if (currStart >= s.length() || s.charAt(currStart) == ')') {
            ++currStart;
            return curr;
        }
        curr.left = helper(s);
        if (currStart >= s.length() || s.charAt(currStart) == ')') {
            ++currStart;
            return curr;
        }
        curr.right = helper(s);
        ++currStart;
        return curr;
    }

    private int readDigit(String s) {
        int start = currStart;
        while (currStart < s.length() && s.charAt(currStart) != ')' && s.charAt(currStart) != '(') currStart++;
        return Integer.parseInt(s.substring(start, currStart));
    }

    public static void main(String[] args) {
        ConstructBinaryTreeFromString constructBinaryTreeFromString = new ConstructBinaryTreeFromString();
        System.out.println(constructBinaryTreeFromString.str2tree("4"));
    }

    private static class TreeNode {
        int val;
        ConstructBinaryTreeFromString.TreeNode left;
        ConstructBinaryTreeFromString.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, ConstructBinaryTreeFromString.TreeNode left, ConstructBinaryTreeFromString.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
