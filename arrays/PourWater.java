package LeetCode.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//https://leetcode.com/problems/pour-water/
public class PourWater {

    //O(nm) can be optimized to O(n + m) with 2 stack leftfall and right fall
    public int[] pourWater(int[] heights, int volume, int k) {
        for (int i = 0; i < volume; i++) {
            int curr = k;
            while (curr > 0 && heights[curr] >= heights[curr - 1]) curr--; //рухаємось до упору вліво
            while (curr < heights.length - 1 && heights[curr] >= heights[curr + 1]) curr++; // тепер рухаємось до упору в право
            while (curr > k && heights[curr] == heights[curr - 1]) curr--; // якщо весь час рухались по плоскому то вертаємось назад
            heights[curr]++;
        }
        return heights;
    }

    public static void main(String[] args) {
        PourWater pourWater = new PourWater();
        System.out.println(Arrays.toString(pourWater.pourWater(new int[]{2, 1, 1, 2, 1, 2, 2}, 4, 3)));
    }
}
