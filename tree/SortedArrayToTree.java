package LeetCode.tree;

// link - https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
public class SortedArrayToTree {

    public static void main(String[] args) {
        SortedArrayToTree sortedArrayToTree = new SortedArrayToTree();
        TreeNode result = sortedArrayToTree.sortedArrayToBST(new int[]{-10,-3,0,5,9});
        System.out.println(":asdf");
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int left, int right) {
        if (left > right) return null;
        if (left == right) return new TreeNode(nums[left]);
        int mid = (left + right) / 2;
        return new TreeNode(nums[mid], helper(nums, left, mid - 1), helper(nums, mid + 1, right));
    }

    private static class TreeNode {
        int val;
        SortedArrayToTree.TreeNode left;
        SortedArrayToTree.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, SortedArrayToTree.TreeNode left, SortedArrayToTree.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
