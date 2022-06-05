package LeetCode.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//https://leetcode.com/problems/find-root-of-n-ary-tree/solution/
public class FindRootOfNAryTree {


    //O(n) time and constant space
    public Node findRoot(List<Node> tree) {
        int result = 0;
        for (Node node : tree) {
            result ^= node.val;
        }
        for (Node node : tree) {
            for (Node child : node.children) {
                result ^= child.val;
            }
        }
        for (Node node : tree) {
            if (node.val == result) return node;
        }
        return null;
    }

    public static void main(String[] args) {
        FindRootOfNAryTree find = new FindRootOfNAryTree();
        //System.out.println(find.findRoot(new FindRootOfNAryTree.Node(1, List.of(new FindRootOfNAryTree.Node(2, List.of(new FindRootOfNAryTree.Node(3, List.of(new FindRootOfNAryTree.Node(5))), new FindRootOfNAryTree.Node(4, List.of(new FindRootOfNAryTree.Node(6)))))))));
    }

    // Definition for a Node.
    static class Node {
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
