package LeetCode.arrays;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/car-pooling/
public class CarPooling {
    public static void main(String[] args) {
        CarPooling carPooling = new CarPooling();
        System.out.println(carPooling.carPooling(new int[][]{{2,1,5}, {3,3,7}}, 5));
    }

    public boolean carPooling(int[][] trips, int capacity) {
        List<int[]> arr = new ArrayList<>(trips.length * 2);
        for (int[] trip : trips) {
            arr.add(new int[]{trip[1], trip[0]});
            arr.add(new int[]{trip[2], -trip[0]});
        }
        arr.sort((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        int curr = 0;
        for (int[] ints : arr) {
            curr += ints[1];
            if (curr > capacity) return false;
        }
        return true;
    }
}
