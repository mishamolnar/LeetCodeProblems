package LeetCode.tree;

//https://leetcode.com/problems/binary-tree-longest-consecutive-sequence-ii/
public class BinaryTreeLongestConsecutiveSequenceII {
    int max = 0;

    public int longestConsecutive(TreeNode root) {
        helper(root);
        return max;
    }

    private int[] helper(TreeNode node) {
        if (node == null) return new int[]{0, 0};
        int inc = 1, dcr = 1;
        if (node.left != null) {
            int[] left = helper(node.left);
            if (node.val == node.left.val - 1) {
                inc = left[0] + 1;
            } else if (node.val == node.left.val + 1) {
                dcr = left[1] + 1;
            }
        }

        if (node.right != null) {
            int[] right = helper(node.right);
            if (node.val == node.right.val - 1) {
                inc = Math.max(inc, right[0] + 1);
            } else if (node.val == node.right.val + 1) {
                dcr = Math.max(inc, right[1] + 1);
            }
        }

        max = Math.max(max, inc + dcr - 1);

        return new int[] {inc, dcr};
    }

    public static void main(String[] args) {
        BinaryTreeLongestConsecutiveSequenceII sequenceII = new BinaryTreeLongestConsecutiveSequenceII();
        //System.out.println(sequenceII.longestConsecutive(new TreeNode(2, new TreeNode(1, null, new TreeNode(5)), new TreeNode(3, null, new TreeNode(4)))));
        System.out.println(sequenceII.longestConsecutive(new TreeNode(2, new TreeNode(1), new TreeNode(3))));
    }


    private static class TreeNode {
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
