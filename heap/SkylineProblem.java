package LeetCode.heap;

import java.util.*;
import java.util.stream.Collectors;

// link - https://leetcode.com/problems/the-skyline-problem/
public class SkylineProblem {

    public List<List<Integer>> getSkyline(int[][] buildings) {
        int[][] heights = new int[buildings.length * 2][2];
        for (int i = 0; i < buildings.length; i++) {
            heights[i * 2] = new int[]{buildings[i][0], - buildings[i][2]}; // негативна висота для початку будівлі
            heights[i * 2 + 1] = new int[]{buildings[i][1], buildings[i][2]}; // позитивна висота для кінця будівлі
        }
        Arrays.sort(heights, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]); // сортуємо по початку будівлі, далі по висоті - спочатку вищі
        TreeMap<Integer, Integer> treeMap = new TreeMap<>(Comparator.reverseOrder()); // мапа з всіма поточними висотами
        treeMap.put(0, 1); // задаємо висоту 0 і активовуємо її (одиничкою)
        int prev = 0; // попередня висота
        List<List<Integer>> result = new ArrayList<>();
        for (int[] h : heights) {
            if (h[1] < 0) {
                treeMap.put(- h[1], treeMap.getOrDefault(-h[1], 0) + 1); // додаємо висоту, дві будівлі на одній висоті - тоді вел'ю два
            } else {
                treeMap.put(h[1], treeMap.get(h[1]) - 1); //зменшуємо вел'ю
                if (treeMap.get(h[1]) == 0) treeMap.remove(h[1]); // якщо нуль - видаляємо
            }
            if (treeMap.firstKey() != prev) { // якщо висота змінилась відносно попередньої
                prev = treeMap.firstKey(); // поточна висота - стає prev
                result.add(List.of(h[0], prev)); // додаємо ікс кординату і висоту
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SkylineProblem skylineProblem = new SkylineProblem();
        System.out.println(skylineProblem.getSkyline(new int[][]{{1,2,1},{1, 2, 2},{1, 2, 3}}));
    }
}
