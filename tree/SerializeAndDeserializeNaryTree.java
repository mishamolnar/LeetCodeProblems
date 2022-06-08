package LeetCode.tree;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/serialize-and-deserialize-n-ary-tree/submissions/
public class SerializeAndDeserializeNaryTree {

    // Encodes a tree to a single string.
    public String serialize(Node root) {
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        inString(root.children, sb);
        return sb.toString();
    }

    private void inString(List<Node> nodes, StringBuilder sb) {
        if (nodes == null) return;
        sb.append('(');
        for (Node node : nodes) {
            sb.append(node.val);
            inString(node.children, sb);
            sb.append(',');
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(')');
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        int val = Integer.parseInt(data.substring(0, data.indexOf('(')));
        List<Node> children = deserializeChildren(data.substring(data.indexOf('(') + 1));
        return new Node(val, children);
    }

    private List<Node> deserializeChildren(String data) {
        List<Node> result = new ArrayList<>();
        String[] arr = data.split(",|(|)");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("")) continue;
            if (arr[i].charAt(0) == ')') break;
            Node node = new Node(Integer.parseInt(arr[i]));
            if (arr[i + 1].charAt(0) == '(') {
                node.children = deserializeChildren(data.substring(data.indexOf('(') + 1));
                while (!arr[i].equals(")")) i++;
                i -= 2;
            }
            result.add(node);
        }
        return result;
    }

    public static void main(String[] args) {
        SerializeAndDeserializeNaryTree serializeAndDeserializeNaryTree = new SerializeAndDeserializeNaryTree();
        System.out.println(serializeAndDeserializeNaryTree.serialize(new SerializeAndDeserializeNaryTree.Node(1, List.of(new SerializeAndDeserializeNaryTree.Node(2, List.of(new SerializeAndDeserializeNaryTree.Node(3, List.of(new SerializeAndDeserializeNaryTree.Node(5))), new SerializeAndDeserializeNaryTree.Node(4, List.of(new SerializeAndDeserializeNaryTree.Node(6)))))))));
        serializeAndDeserializeNaryTree.deserialize("1(2(3(5),4(6)))");
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}

//premium solution
//class Codec {
//
//    class WrappableInt {
//        private int value;
//        public WrappableInt(int x) {
//            this.value = x;
//        }
//        public int getValue() {
//            return this.value;
//        }
//        public void increment() {
//            this.value++;
//        }
//    }
//
//    // Encodes a tree to a single string.
//    public String serialize(Node root) {
//
//        StringBuilder sb = new StringBuilder();
//        this._serializeHelper(root, sb);
//        return sb.toString();
//    }
//
//    private void _serializeHelper(Node root, StringBuilder sb) {
//
//        if (root == null) {
//            return;
//        }
//
//        // Add the value of the node
//        sb.append((char) (root.val + '0'));
//
//        // Add the number of children
//        sb.append((char) (root.children.size() + '0'));
//
//        // Recurse on the subtrees and build the
//        // string accordingly
//        for (Node child : root.children) {
//            this._serializeHelper(child, sb);
//        }
//    }
//
//    // Decodes your encoded data to tree.
//    public Node deserialize(String data) {
//        if(data.isEmpty())
//            return null;
//
//        return this._deserializeHelper(data, new WrappableInt(0));
//    }
//
//    private Node _deserializeHelper(String data, WrappableInt index) {
//
//        if (index.getValue() == data.length()) {
//            return null;
//        }
//
//        // The invariant here is that the "index" always
//        // points to a node and the value next to it
//        // represents the number of children it has.
//        Node node = new Node(data.charAt(index.getValue()) - '0', new ArrayList<Node>());
//        index.increment();
//        int numChildren = data.charAt(index.getValue()) - '0';
//        for (int i = 0; i < numChildren; i++) {
//            index.increment();
//            node.children.add(this._deserializeHelper(data, index));
//        }
//
//        return node;
//    }
//}
