package LeetCode.tree;

import java.util.HashSet;

public class LowestCommonAncestorOfBinaryTreeIII {
    public static void main(String[] args) {

    }

    //this is the problem if intersection of 2 linked lists
    //O(1) space and log time
    public Node lowestCommonAncestorRunners(Node p, Node q) {
        Node pRunner = p, qRunner = q;
        while (qRunner.val != pRunner.val) {
            pRunner = pRunner.parent == null ? q : pRunner.parent;
            qRunner = qRunner.parent == null ? p : qRunner.parent;
        }
        return qRunner;
    }

    //O(n log n) time and space
    public Node lowestCommonAncestor(Node p, Node q) {
        HashSet<Integer> set = new HashSet<>();
        while (p.parent != null) {
            set.add(p.val);
            p = p.parent;
        }
        while (!set.contains(q.val)) q = q.parent;
        return q;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }
}
