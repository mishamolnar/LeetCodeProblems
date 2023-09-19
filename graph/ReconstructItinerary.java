package LeetCode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ReconstructItinerary {
    public List<String> findItinerary(List<List<String>> tickets) {
        tickets.sort((a, b) -> a.get(0).equals(b.get(0)) ? a.get(0).compareTo(b.get(0)) : a.get(1).compareTo(b.get(1)));
        Map<String, List<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            graph.putIfAbsent(ticket.get(0), new ArrayList<>());
            graph.get(ticket.get(0)).add(ticket.get(1));
        }
        return Arrays.stream(dfs("JFK", "", graph, 0, tickets.size()).split(" ")).toList();
    }

    public String dfs(String curr, String path, Map<String, List<String>> graph, int count, int total) {
        String newPath = path + " " + curr;
        if (count == total) {
            return newPath.substring(1);
        } else  {
            List<String> neib = List.copyOf(graph.getOrDefault(curr, Collections.emptyList()));
            for (int i = 0; i < neib.size(); i++) {
                if (neib.get(i).equals("")) continue;
                graph.get(curr).set(i, "");
                String res = dfs(neib.get(i), newPath, graph, count + 1, total);
                if (!res.isEmpty()) return res;
                graph.get(curr).set(i, neib.get(i));
            }
        }
        return "";
    }

    //[["TIA","JFK"],["TIA","JFK"],["JFK","ANU"],["JFK","DIA"],["ANU","TIA"],["DIA","TIA"]]
    public static void main(String[] args) {
        System.out.println(new ReconstructItinerary().findItinerary(List.of(
                List.of("TIA","JFK"),
                List.of("TIA","JFK"),
                List.of("JFK","ANU"),
                List.of("JFK","DIA"),
                List.of("ANU","TIA"),
                List.of("DIA","TIA")
        )));
    }
}
