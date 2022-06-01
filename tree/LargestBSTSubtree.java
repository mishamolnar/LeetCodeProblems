package LeetCode.tree;

//https://leetcode.com/problems/largest-bst-subtree/
public class LargestBSTSubtree {

    //O(n) time and space complexity
    public int largestBSTSubtree(TreeNode root) {
        return helper(root).maxSize;
    }

    private NodeValue helper(TreeNode root) {
        // Якщо нода нал - то передаємо максимально можливі кордони, бо батьківська нода може бути абсолютно будь якою
        if (root == null) return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);

        NodeValue left = helper(root.left); //знаходимо кордони для лівого піддерева
        NodeValue right = helper(root.right); // і для правого

        if (root.val > left.maxNode && root.val < right.minNode) { //якщо ця нода більша за найбільшу в лівому піддереві і менша за найменшу в правому - це валідне дерево
            return new NodeValue(Math.min(root.val, left.minNode), Math.max(root.val, right.maxNode), //тому передаємо вверх нові (злиті кордони)
                    left.maxSize + right.maxSize + 1);
        }

        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize)); //якщо це не валідне дерево то прокидуємо вверх
        //найбільше значення з дочірніх величин дерева
        // і кордони - правий кордон це мінімальне значення і лівий максимальне - тому всі наступні батьківські ноди не зможуть бути валідними БСТ
    }

    private class NodeValue{
        private int maxNode, minNode, maxSize;

        NodeValue(int minNode, int maxNode, int maxSize) {
            this.maxNode = maxNode;
            this.minNode = minNode;
            this.maxSize = maxSize;
        }
    }

    public static void main(String[] args) {
        LargestBSTSubtree largestBSTSubtree = new LargestBSTSubtree();
        System.out.println(largestBSTSubtree.largestBSTSubtree(new TreeNode(1, new TreeNode(2), null)));
    }

    private static class TreeNode {
        int val;
        LargestBSTSubtree.TreeNode left;
        LargestBSTSubtree.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, LargestBSTSubtree.TreeNode left, LargestBSTSubtree.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
