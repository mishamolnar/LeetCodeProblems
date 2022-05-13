package LeetCode.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// link - https://leetcode.com/problems/intersection-of-two-arrays-ii/
public class IntersectionOfTwoArraysII {

    public static void main(String[] args) {

    }


    //O(n) time and space
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> intersections = new HashMap<>();
        for (int j : nums1) {
            intersections.put(j, intersections.getOrDefault(j, 0) + 1);
        }
        List<Integer> result = new ArrayList<>();
        for (int i : nums2) {
            if (intersections.getOrDefault(i, 0) > 0) {
                result.add(i);
                intersections.put(i, intersections.get(i) - 1);
            }
        }
        return result.stream().mapToInt(i->i).toArray();
    }
}
