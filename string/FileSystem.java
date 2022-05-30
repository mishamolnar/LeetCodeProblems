package LeetCode.string;

import java.util.HashMap;


//https://leetcode.com/problems/design-file-system/solution/
public class FileSystem {
    private Node root;

    public FileSystem() {
        this.root = new Node("", -1);
    }

    //O(t) space and time, where t - number of unique directories
    public boolean createPath(String path, int value) {
        String[] arr = path.split("/");
        Node buff = root;
        for (int i = 1; i < arr.length - 1; i++) {
            buff = buff.children.getOrDefault(arr[i], null);
            if (buff == null) return false;
        }
        if (buff.children.containsKey(arr[arr.length - 1])) return false;
        buff.children.put(arr[arr.length - 1], new Node(arr[arr.length - 1], value));
        return true;
    }

    public int get(String path) {
        String[] arr = path.split("/");
        Node buff = root;
        for (int i = 1; i < arr.length; i++) { //від одного бо перший елемент завжди ""
            buff = buff.children.getOrDefault(arr[i], null);
            if (buff == null) return -1;
        }
        return buff.val;
    }

    private class Node{
        private String dir;
        private int val;
        private HashMap<String, Node> children = new HashMap<>();

        public Node(String dir, int val) {
            this.dir = dir;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        FileSystem fileSystem = new FileSystem();

        System.out.println(fileSystem.createPath("/leet", 1));// return true
        System.out.println(fileSystem.createPath("/leet/code", 2));// return true
        System.out.println(fileSystem.get("/leet/code")); // return 2
        System.out.println(fileSystem.createPath("/c/d", 1)); // return false because the parent path "/c" doesn't exist.
        System.out.println(fileSystem.get("/c")); // return -1 because this path doesn't exist.

    }
}
