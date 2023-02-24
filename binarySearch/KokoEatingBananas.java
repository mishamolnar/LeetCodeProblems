package LeetCode.binarySearch;

import java.util.Arrays;

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int H) {
        int l = 1, r = 1000000000;
        while (l < r) {
            int m = (l + r) / 2, total = 0;
            for (int p : piles)
                total += (p + m - 1) / m;
            if (total > H)
                l = m + 1;
            else
                r = m;
        }
        return l;
    }

    public static void main(String[] args) {
        KokoEatingBananas kokoEatingBananas = new KokoEatingBananas();
        System.out.println(kokoEatingBananas.minEatingSpeed(new int[]{805306368,805306368,805306368},
        1000000000));
    }



    public int minEatingSpeedTwo(int[] piles, int h) {
        int left = 0, right = Arrays.stream(piles).max().getAsInt();
        while (right - left > 1) {
            int middle = left + (right - left) / 2;
            if (test(piles, h, middle)) {
                right = middle;
            } else {
                left = middle;
            }
        }
        return right;
    }

    private boolean test(int[] piles, int h, int speed) {
        for (int pile : piles) {
            h -= pile / speed;
            h -= pile % speed > 0 ? 1 : 0;
        }
        return h >= 0;
    }
}
