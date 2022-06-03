package LeetCode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/smallest-common-region/
public class SmallestCommonRegion {

    //O(n) time and space
    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        Map<String, String> map = new HashMap<>();
        for (List<String> region : regions) {
            for (int i = 1; i < region.size(); i++) {
                map.put(region.get(i), region.get(0));
            }
        }
        String first = region1;
        String second = region2;
        while (!first.equals(second)) {
            first = map.getOrDefault(first, region2);
            second = map.getOrDefault(second, region1);
        }
        return first;
    }

    public static void main(String[] args) {
        SmallestCommonRegion smallestCommonRegion = new SmallestCommonRegion();
        System.out.println(smallestCommonRegion.findSmallestRegion(
                List.of(List.of("Earth","North America","South America"),
                        List.of("North America","United States","Canada"),
                        List.of("United States","New York","Boston"),
                        List.of("Canada","Ontario","Quebec"),
                        List.of("South America","Brazil")), "Canada", "Quebec"));
    }
}
