package LeetCode.string;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

//https://leetcode.com/problems/simplify-path/submissions/
public class SimplifyPath {
    public static void main(String[] args) {
        SimplifyPath simplifyPath = new SimplifyPath();
        System.out.println(simplifyPath.simplifyPathTwo("/home/"));
    }

    public String simplifyPath(String path) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] arr = path.split("/|//");
        Stack<Integer> starts = new Stack<>();
        starts.add(0);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].isEmpty()) continue;
            if (arr[i].length() == 1 && arr[i].charAt(0) == '.') continue;
            if (arr[i].equals("..")) {
                if (!starts.isEmpty()) stringBuilder.delete(starts.pop(), stringBuilder.length());
                continue;
            }
            starts.add(stringBuilder.length());
            stringBuilder.append('/');
            stringBuilder.append(arr[i]);
        }
        return stringBuilder.length() == 0 ? "/" : stringBuilder.toString();
    }

    public String simplifyPathWithStack(String path) {
        Deque<String> stack = new LinkedList<>();
        for (String dir : path.split("/")) {
            if (dir.equals("..") && !stack.isEmpty()) stack.pop(); // if .. remove element from stack
            else if (!dir.equals("") && !dir.equals("..") && !dir.equals(".")) stack.push(dir); //else just add element in stack
        }
        String res = "";
        for (String dir : stack) res = "/" + dir + res; //connecting all components
        return res.isEmpty() ? "/" : res;
    }


    public String simplifyPathTwo(String path) {
        String[] arr = path.split("/+");
        int pointer = 0;
        for (String dir : arr) {
            if (dir.equals("..")) {
                pointer = Math.max(0, pointer - 1);
            } else if (!dir.equals(".") && !dir.isEmpty()) {
                arr[pointer++] = dir;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pointer; i++) {
            sb.append("/").append(arr[i]);
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
