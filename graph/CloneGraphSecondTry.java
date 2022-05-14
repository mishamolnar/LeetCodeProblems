package LeetCode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//https://leetcode.com/problems/clone-graph/
public class CloneGraphSecondTry {

    public static void main(String[] args) {

    }

    public Node cloneGraph(Node node) {
        HashMap<Integer, Node> hashMap = new HashMap<>();
        return cloneHelper(node, hashMap);
    }

    private Node cloneHelper(Node node, HashMap<Integer, Node> used) {
        Node result = new Node(node.val);
        result.neighbors = new ArrayList<>();
        used.put(node.val, result);
        for (Node neighbor : node.neighbors) {
            if (used.containsKey(neighbor.val)) result.neighbors.add(used.get(neighbor.val));
            else result.neighbors.add(cloneHelper(neighbor, used));
        }
        return result;
    }

    private static class Node {
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
