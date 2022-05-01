package LeetCode.heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// link - https://leetcode.com/problems/top-k-frequent-elements/
public class TopKFrequentElements {


    // O(n) time and space complexity
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> occurances = new HashMap<>();
        for (Integer i : nums) {
            occurances.put(i, occurances.getOrDefault(i, 0) + 1); // add all elements with their frequencies
        }

        List<Integer>[] sorted = new ArrayList[nums.length + 1];
        for (Integer i : occurances.keySet()) {
            int number = occurances.get(i);
            if (sorted[number] == null) {
                sorted[number] = new ArrayList<Integer>(); // add element that occurs 3 times to the 4 position (0, 1, 2, 3)
            }
            sorted[number].add(i);
        }

        int[] result = new int[k];
        for (int i = sorted.length - 1; i > 0 && k > 0; i--) {
            if (sorted[i] == null) continue;
            while (sorted[i].size() != 0){
                result[k - 1] = sorted[i].remove(sorted[i].size() - 1); // add elements from created array in resulted list
                k--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        topKFrequentElements.topKFrequent(new int[]{1,1,1,2,2,3}, 2);
    }
}
