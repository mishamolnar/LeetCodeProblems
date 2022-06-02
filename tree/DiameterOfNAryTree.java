package LeetCode.tree;

import java.util.ArrayList;
import java.util.List;


//https://leetcode.com/problems/diameter-of-n-ary-tree/
public class DiameterOfNAryTree {
    private int max = 0;

    public int diameter(Node root) {
        helper(root);
        return this.max;
    }


    //O(n) time and space in worst case (space can be better)
    private int helper(Node root) {
        int one = Integer.MIN_VALUE, two = Integer.MIN_VALUE;
        if (root.children == null || root.children.isEmpty()) return 1;
        for (Node child : root.children) {
            int buff = helper(child);
            if (buff > one) {
                two = one;
                one = buff;
            } else two = Math.max(two, buff);
        }
        max = Math.max(max, Math.max(one, one + two));
        return one + 1;
    }

    public static void main(String[] args) {
        DiameterOfNAryTree diameter = new DiameterOfNAryTree();
        System.out.println(diameter.diameter(new Node(1, List.of(new Node(2, List.of(new Node(3, List.of(new Node(5))), new Node(4, List.of(new Node(6)))))))));
    }

    private static class Node {
        public int val;
        public List<Node> children;


        public Node() {
            children = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<Node>();
        }

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
