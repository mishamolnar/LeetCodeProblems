package LeetCode.arrays;

import java.util.HashMap;
import java.util.HashSet;

//https://leetcode.com/problems/longest-consecutive-sequence/submissions/
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int curr = num, currStreak = 1;
                while (set.contains(curr + 1)) {
                    curr++;
                    currStreak++;
                }
                res = Math.max(res, currStreak);
            }
        }
        return res;
    }

    //hashtable solution
    public int longestConsecutiveTwo(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            if (map.containsKey(num)) continue;
            if (!map.containsKey(num + 1) && !map.containsKey(num - 1)) {
                map.put(num, 0);
                continue;
            }
            if (map.containsKey(num + 1)) {
                res = Math.max(res, mergeIntervals(map, num, num + 1));
            }
            if (map.containsKey(num - 1)) {
                res = Math.max(res, mergeIntervals(map, num, num - 1));
            }
        }
        return res;
    }

    private int mergeIntervals(HashMap<Integer, Integer> map, int i, int j) {
        int min = Math.min(Math.min(i, i + map.getOrDefault(i, 0)), Math.min(j, j + map.getOrDefault(j, 0)));
        int max = Math.max(Math.max(i, i + map.getOrDefault(i, 0)), Math.max(j, j + map.getOrDefault(j, 0)));
        map.remove(i);
        map.remove(j);
        map.remove(i + map.getOrDefault(i, 0));
        map.remove(j + map.getOrDefault(j, 0));
        map.put(max, min - max);
        map.put(min, max - min);
        return max - min + 1;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence longest = new LongestConsecutiveSequence();
        System.out.println(longest.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }
}
