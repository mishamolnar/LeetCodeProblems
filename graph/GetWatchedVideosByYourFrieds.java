package LeetCode.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;

public class GetWatchedVideosByYourFrieds {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> q = new ArrayDeque<>();
        visited.add(id);
        q.add(id);
        while (!q.isEmpty() && level > 0) {
            level--;
            for (int i = q.size(); i > 0; i--) {
                int curr = q.poll();
                for (int friend : friends[curr]) {
                    if (!visited.contains(friend)) {
                        q.add(friend);
                    }
                }
            }
        }

        Map<String, Integer> map = new HashMap<>();
        while (!q.isEmpty()) {
            for (String s : watchedVideos.get(q.peek())) {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }

        List<String> res = new ArrayList<>(map.keySet());
        res.sort((a, b) -> map.get(a).equals(map.get(b)) ? Integer.compare(map.get(a), map.get(b)) : a.compareTo(b));
        return res;
    }
}
