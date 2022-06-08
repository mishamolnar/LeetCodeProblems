package LeetCode.tree;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

//https://leetcode.com/problems/design-in-memory-file-system/
public class FileSystem {
    private Node root;

    public FileSystem() {
        this.root = new Node("", null);
    }

    public List<String> ls(String path) {
        String[] arr = path.split("/");
        Node buff = root;
        for (String s : arr) {
            if (s.equals("")) continue;;
            buff = buff.directories.getOrDefault(s, buff);
        }
        return buff.content != null ? List.of(buff.name) : buff.directories.keySet().stream().sorted().collect(Collectors.toList());
    }

    public void mkdir(String path) {
        String[] arr = path.split("/");
        Node buff = root;
        for (String s : arr) {
            if (s.equals("")) continue;;
            buff.directories.putIfAbsent(s, new Node(s, null));
            buff = buff.directories.get(s);
        }
    }

    public void addContentToFile(String filePath, String content) {
        String[] arr = filePath.split("/");
        Node buff = root;
        for (String s : arr) {
            if (s.equals("")) continue;;
            buff.directories.putIfAbsent(s, new Node(s, null));
            buff = buff.directories.get(s);
        }
        if (buff.content == null) buff.content = content;
        else buff.content = buff.content + content;
    }

    public String readContentFromFile(String filePath) {
        String[] arr = filePath.split("/");
        Node buff = root;
        for (String s : arr) {
            if (s.equals("")) continue;;
            buff.directories.putIfAbsent(s, new Node(s, null));
            buff = buff.directories.get(s);
        }
        return buff.content;
    }


    private class Node {
        String name;
        String content;
        HashMap<String, Node> directories;

        public Node(String name, String content) {
            this.name = name;
            this.content = content;
            directories = new HashMap<>();
        }
    }

    public static void main(String[] args) {
        FileSystem fileSystem = new FileSystem();
        System.out.println(fileSystem.ls("/"));                         // return []
        fileSystem.mkdir("/a/b/c");
        fileSystem.addContentToFile("/a/b/c/d", "hello");
        System.out.println(fileSystem.ls("/"));                         // return ["a"]
        System.out.println(fileSystem.readContentFromFile("/a/b/c/d")); // return "hello"

    }
}
