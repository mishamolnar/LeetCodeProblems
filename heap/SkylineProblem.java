package LeetCode.heap;

import java.util.*;
import java.util.stream.Collectors;

// link - https://leetcode.com/problems/the-skyline-problem/
public class SkylineProblem {

    public List<List<Integer>> getSkylineII(int[][] buildings) {
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




    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> arr = new ArrayList<>();
        for (int[] building : buildings) {
            arr.add(new int[]{building[0], building[2]});
            arr.add(new int[]{building[1], -building[2]});
        }

        arr.sort((a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        List<List<Integer>> list = new ArrayList<>();
        for (int[] dot : arr) {
            map.put(Math.abs(dot[1]), map.getOrDefault(Math.abs(dot[1]), 0) + (dot[1] > 0 ? 1 : -1));
            if (map.get(Math.abs(dot[1])) == 0)
                map.remove(Math.abs(dot[1]));
            int ceil = map.isEmpty() ? 0 : map.lastKey();
            if (list.isEmpty() || list.get(list.size() - 1).get(1) != ceil)
                list.add(List.of(dot[0], ceil));
        }

        return list;
    }

    public static void main(String[] args) {
        SkylineProblem skylineProblem = new SkylineProblem();
//        System.out.println(skylineProblem.getSkyline(new int[][]{{1,2,1},{1, 2, 2},{1, 2, 3}}));
        System.out.println(skylineProblem.getSkyline(new int[][]{{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}}));
    }
}
