package LeetCode.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class MinimumGeneticMutation {
    private static final char[] gens = new char[]{'A', 'C', 'G', 'T'};

    public int minMutation(String start, String end, String[] bank) {
        Set<String> available = Arrays.stream(bank).collect(Collectors.toSet());
        Set<String> visited = new HashSet<>();
        Queue<String> q = new ArrayDeque<>();
        q.add(start);
        visited.add(start);
        int steps = 0;
        while (!q.isEmpty()) {
            steps++;
            for (int i = q.size(); i > 0; i--) {
                String curr = q.poll();
                for (String s : getNext(curr, available)) {
                    if (s.equals(end))
                        return steps;
                    if (!visited.contains(s)) {
                        q.add(s);
                        visited.add(s);
                    }
                }
            }
        }
        return -1;
    }

    private List<String> getNext(String curr, Set<String> available) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder(curr);
        for (int i = 0; i < 8; i++) {
            char buff = curr.charAt(i);
            for (char gen : gens) {
                sb.setCharAt(i, gen);
                if (available.contains(sb.toString()))
                    res.add(sb.toString());
            }
            sb.setCharAt(i, buff);
        }
        return res;
    }
}
