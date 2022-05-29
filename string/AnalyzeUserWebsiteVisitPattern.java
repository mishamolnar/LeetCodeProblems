package LeetCode.string;

import java.util.*;

//https://leetcode.com/problems/analyze-user-website-visit-pattern/submissions/
//n3 space and n! time complexity
public class AnalyzeUserWebsiteVisitPattern {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        TreeMap<Integer, String[]> logs = new TreeMap<>();
        for (int i = 0; i < username.length; i++) {
            logs.put(timestamp[i], new String[]{username[i], website[i]});
        }
        int max = 0;
        HashMap<String, LinkedList<String>> list = new HashMap<>();
        HashMap<List<String>, Integer> counts = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        for (String[] value : logs.values()) {
            list.putIfAbsent(value[0], new LinkedList<>());
            list.get(value[0]).add(value[1]);
        }
        for (LinkedList<String> value : list.values()) {
            List<List<String>> patterns = new ArrayList<>();
            getAllPatterns(patterns, value, new ArrayList<>(), 0);
            for (List<String> pattern : patterns) {
                int curr  = counts.getOrDefault(pattern, 0) + 1;
                counts.put(pattern, curr);
                if (curr == max) result.add(pattern);
                else if (curr > max) {
                    max = curr;
                    result = new ArrayList<>();
                    result.add(pattern);
                }
            }
        }
        if (result.size() == 1) return result.get(0);
        result.sort((a, b) -> a.get(0).compareTo(b.get(0)) != 0 ? a.get(0).compareTo(b.get(0)) :
                a.get(1).compareTo(b.get(1)) != 0 ? a.get(1).compareTo(b.get(1)) : a.get(2).compareTo(b.get(2)));
        return result.get(0);
    }

    private void getAllPatterns(List<List<String>> result, List<String> visited, List<String> current, int index) {
        if (current.size() == 3) result.add(current);
        else {
            for (int i = index; i < visited.size(); i++) {
                current.add(visited.get(i));
                getAllPatterns(result, visited, new ArrayList<>(current), i + 1);
                current.remove(current.size() - 1);
            }
        }
    }
}
