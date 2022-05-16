package LeetCode.tree;

import com.sun.source.tree.Tree;

import java.util.Stack;


// https://leetcode.com/problems/kth-smallest-element-in-a-bst/
public class KthSmallestElementInBST {
    private static int number = 0;
    private static int count = 0;

    public static void main(String[] args) {
        KthSmallestElementInBST KthSmallestElementInBST = new KthSmallestElementInBST();
        System.out.println(KthSmallestElementInBST.kthSmallest(new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), new TreeNode(4)), 2));
    }

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        helper(root);
        return number;
    }

    public void helper(TreeNode n) {
        if (n.left != null) helper(n.left);
        count--;
        if (count == 0) {
            number = n.val;
            return;
        }
        if (n.right != null) helper(n.right);
    }

    public int kthSmallestIterative(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();

        while (root != null) {
            st.push(root);
            root = root.left;
        }

        while (k != 0) {
            TreeNode n = st.pop();
            k--;
            if (k == 0) return n.val;
            TreeNode right = n.right;
            while (right != null) {
                st.push(right);
                right = right.left;
            }
        }

        return -1; // never hit if k is valid
    }


    private static class TreeNode {
        int val;
        KthSmallestElementInBST.TreeNode left;
        KthSmallestElementInBST.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, KthSmallestElementInBST.TreeNode left, KthSmallestElementInBST.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
