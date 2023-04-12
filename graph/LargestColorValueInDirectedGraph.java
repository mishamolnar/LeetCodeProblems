package LeetCode.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class LargestColorValueInDirectedGraph {


    //kahn's algo
    public int largestPathValue(String colors, int[][] edges) {
        List<Integer>[] graph = new List[colors.length()];
        int[] inbound = new int[colors.length()];
        for (int i = 0; i < colors.length(); i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            inbound[edge[1]]++;
        }
        Queue<Integer> withInboundZero = new ArrayDeque<>();
        for (int i = 0; i < inbound.length; i++) {
            if (inbound[i] == 0) {
                withInboundZero.add(i);
            }
        }
        int[][] scores = new int[colors.length()][26];
        int ans = -1;
        while (!withInboundZero.isEmpty()) {
            int curr = withInboundZero.poll();
            scores[curr][colors.charAt(curr) - 'a']++;
            ans = Math.max(ans, scores[curr][colors.charAt(curr) - 'a']);
            for (Integer next : graph[curr]) {
                for (int i = 0; i < 26; i++) {
                    scores[next][i] = Math.max(scores[next][i], scores[curr][i]);
                }
                inbound[next]--;
                if (inbound[next] == 0) {
                    withInboundZero.add(next);
                }
            }
        }
        return Arrays.stream(inbound).anyMatch(a -> a > 0) ? -1 : ans;
    }



    //tle, complexity n2
    public int largestPathValueTwo(String colors, int[][] edges) {
        List<Integer>[] graph = new List[colors.length()];
        int[] inbound = new int[colors.length()];
        for (int i = 0; i < colors.length(); i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            inbound[edge[1]]++;
        }
        int[] scores = new int[26];
        boolean[] stack = new boolean[colors.length()];
        int ans = -1;
        for (int i = 0; i < inbound.length; i++) {
            if (inbound[i] == 0) {
                int res = dfs(i, colors, graph, scores, stack);
                if (res == -1) {
                    return -1;
                } ans = Math.max(res, ans);
                Arrays.fill(scores, 0);
                Arrays.fill(stack, false);
            }
        }
        return ans;
    }

    private int dfs(int curr, String colors, List<Integer>[] graph, int[] scores, boolean[] stack) {
        if (stack[curr]) {
            return -1;
        }
        stack[curr] = true;
        int ans = ++scores[colors.charAt(curr) - 'a'];
        for (Integer next : graph[curr]) {
            int nextRes = dfs(next, colors, graph, scores, stack);
            if (nextRes == -1) {
                return -1;
            } else ans = Math.max(ans, nextRes);
        }
        stack[curr] = false;
        scores[colors.charAt(curr) - 'a']--;
        return ans;
    }
}
