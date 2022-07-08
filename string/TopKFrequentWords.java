package LeetCode.string;

import java.util.*;
import java.util.stream.Collectors;

//https://leetcode.com/problems/top-k-frequent-words/submissions/
public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>(
                (a, b) -> !map.get(b).equals(map.get(a)) ? map.get(a) - map.get(b) : b.compareTo(a));

        for (String s : map.keySet()) {
            pq.add(s);
            if (pq.size() > k) pq.poll();
        }

        List<String> res = new LinkedList<>();
        while (!pq.isEmpty()) {
            res.add(0, pq.poll());
        }
        return res;
    }

    public static void main(String[] args) {
        TopKFrequentWords top = new TopKFrequentWords();
        System.out.println(top.topKFrequent(new String[]{"i","love","leetcode","i","love","coding"}, 2));
    }
}
