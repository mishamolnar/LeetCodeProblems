package LeetCode.graph;

import java.util.*;

//link -- https://leetcode.com/problems/clone-graph/submissions/
// time O(n) and space O(n + m) n - number of vertices, m - number of edges.
public class CloneGraph {
    private HashMap<Integer, Node> newNodes = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        if (newNodes.containsKey(node.val)) return newNodes.get(node.val);

        Node newNode = new Node(node.val);
        newNodes.put(node.val, newNode);

        for (Node neib : node.neighbors) {
            newNode.neighbors.add(cloneGraph(neib));
        }

        return newNode;
    }

    public static void main(String[] args) {
        Node node0 = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node0.neighbors.add(node1);
        node1.neighbors.add(node2);
        node2.neighbors.add(node3);
        node3.neighbors.add(node0);

        CloneGraph cloneGraph = new CloneGraph();
        Node newNode0 = cloneGraph.cloneGraph(node0);
        System.out.println(newNode0 == node0);
        System.out.println(newNode0.neighbors.get(0) == node1);
        System.out.println(newNode0.val + "+" + node0.val);
        System.out.println(newNode0.neighbors.get(0).val + "+" + node1.val);
    }

    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}


