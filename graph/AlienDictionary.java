package LeetCode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

//
public class AlienDictionary {
    private boolean hasCycle = false;
    private boolean[] visited = new boolean[27];
    private boolean[] onStack = new boolean[27];
    private boolean[] includes = new boolean[27];
    private Stack<Character> stack = new Stack<>();

    //O(c) time
    //O(1) space
    public String alienOrder(String[] words) {
        Node[] G = new Node[27];
        for (int i = 0; i < 27; i++) G[i] = new Node((char) (i + 'a'));
        if (words.length == 1) return getDistinct(words[0]);
        for (int i = 0; i < words.length - 1; i++) {
            if (words[i].length() > words[i + 1].length() && words[i].startsWith(words[i + 1])) return "";
            for (char c : words[i].toCharArray()) includes[c - 'a'] = true;
            for (char c : words[i + 1].toCharArray()) includes[c - 'a'] = true;
            int pointer = 0;
            while (pointer < Math.min(words[i].length(), words[i + 1].length())
                    && words[i].charAt(pointer) == words[i + 1].charAt(pointer)) pointer++;
            if (pointer >= Math.min(words[i].length(), words[i + 1].length())) continue;
            G[words[i].charAt(pointer) - 'a'].next.add(G[words[i + 1].charAt(pointer) - 'a']);
        }
        for (int i = 0; i < 27; i++) if (!visited[i] && includes[i]) DFS(i, G);
        if (this.hasCycle) return "";
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append(stack.pop());
        return sb.toString();
    }

    private String getDistinct(String s) {
        boolean[] arr = new boolean[27];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (arr[s.charAt(i) - 'a']) continue;
            arr[s.charAt(i) - 'a'] = true;
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    private void DFS(int curr, Node[] G) {
        visited[curr] = true;
        onStack[curr] = true;
        for (Node node : G[curr].next) {
            int v = node.val - 'a';
            if (onStack[v]) {
                this.hasCycle = true;
            } else if (!visited[v]) {
                DFS(v, G);
            }
        }
        onStack[curr] = false;
        stack.add(G[curr].val);
    }

    public static void main(String[] args) {
        AlienDictionary alienDictionary = new AlienDictionary();
        System.out.println(alienDictionary.alienOrder(new String[]{"z","z"}));
    }

    private class Node{
        char val;
        List<Node> next;

        public Node(char val) {
            this.val = val;
            this.next = new ArrayList<>();
        }
    }
}
