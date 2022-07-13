package LeetCode.arrays;

import java.util.Arrays;
import java.util.Random;
import java.util.TreeMap;

//https://leetcode.com/problems/random-pick-with-weight/
public class RandomPickWithWeight {
    Random random = new Random();
    int[] w;
    int sum;

    public RandomPickWithWeight(int[] w) {
        for (int i = 1; i < w.length; i++) {
            w[i] += w[i - 1];
        }
        this.w = w;
        this.sum = w[w.length - 1];
    }

    public int pickIndex() {
        int r = random.nextInt(sum) + 1;
        return binarySearch(r);
    }

    private int binarySearch(int r) {
        int left = 0, right = w.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (w[mid] == r) return mid;
            if (w[mid] < r) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    public static void main(String[] args) {
        RandomPickWithWeight randomPickWithWeight = new RandomPickWithWeight(new int[]{3, 14, 1, 7});
        randomPickWithWeight.pickIndex();
        randomPickWithWeight.pickIndex();
    }


}
