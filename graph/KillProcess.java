package LeetCode.graph;

import java.util.*;

public class KillProcess {

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer, List<Integer>> G = new HashMap<>();
        for (int i = 0; i < ppid.size(); i++) {
            G.putIfAbsent(ppid.get(i), new ArrayList());
            G.get(ppid.get(i)).add(pid.get(i));
        }
        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        queue.add(kill);
        result.add(kill);
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (G.get(curr) == null) continue;
            queue.addAll(G.get(curr));
            result.addAll(G.get(curr));
        }
        return result;
    }
}
