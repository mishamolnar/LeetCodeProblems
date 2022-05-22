package LeetCode.arrays;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

//https://leetcode.com/problems/heaters/
public class Heaters {

    public static void main(String[] args) {
        Heaters heaters = new Heaters();
        System.out.println(heaters.findRadius(new int[]{1,5}, new int[]{2}));
    }

    public int findRadius(int[] houses, int[] heaters) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int heater : heaters) set.add(heater);
        int max = Integer.MIN_VALUE;
        for (int house : houses) {
            Integer right = set.ceiling(house);
            Integer left = set.floor(house);
            max = Math.max(max, Math.min(right == null ? Integer.MAX_VALUE : Math.abs(house - right), left == null ? Integer.MAX_VALUE : Math.abs(house - left)));
        }
        return max;
    }


}
