package LeetCode.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class FindKPairsSmallestSum {

    //k * k * log (k^2)
    public List<List<Integer>> kSmallestPairsSlow(int[] nums1, int[] nums2, int k) {
        //first pointer and second pointer
        //initially 1, 1, this pair is already added
        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.get(0) + a.get(1), b.get(0) + b.get(1)));
        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            for (int j = 0; j < Math.min(k, nums2.length); j++) {
                pq.add(List.of(nums1[i], nums2[j]));
            }
        }
        for (int i = 0; i < k & !pq.isEmpty(); i++) {
            res.add(pq.poll());
        }
        return res;
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        Set<Map.Entry<Integer, Integer>> visited = new HashSet<>();
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        pq.add(new int[]{nums1[0] + nums2[0], 0, 0});
        while (k > 0 && !pq.isEmpty()) {
            int[] curr = pq.poll();
            int left = curr[1], right = curr[2];
            res.add(List.of(nums1[left], nums2[right]));

            if (left + 1 < nums1.length && !visited.contains(Map.entry(left + 1, right))) {
                pq.add(new int[]{nums1[left + 1] + nums2[right], left + 1, right});
                visited.add(Map.entry(left + 1, right));
            }

            if (right + 1 < nums2.length && !visited.contains(Map.entry(left, right + 1))) {
                pq.add(new int[]{nums1[left] + nums2[right + 1], left, right + 1});
                visited.add(Map.entry(left, right + 1));
            }
            k--;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new FindKPairsSmallestSum().kSmallestPairs(new int[]{1, 2}, new int[]{3}, 3));
    }
}
