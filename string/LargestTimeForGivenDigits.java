package LeetCode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/largest-time-for-given-digits/
public class LargestTimeForGivenDigits {


    public static void main(String[] args) {
        LargestTimeForGivenDigits largestTimeForGivenDigits = new LargestTimeForGivenDigits();
        System.out.println(largestTimeForGivenDigits.largestTimeFromDigits(new int[]{5,5,5,5}));
    }

    //shorter solution
    public String largestTimeFromDigitsShort(int[] A) {
        String ans = "";
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                for (int k = 0; k < 4; ++k) {
                    if (i == j || i == k || j == k) continue; // avoid duplicate among i, j & k.
                    String h = "" + A[i] + A[j];
                    String m = "" + A[k] + A[6 - i - j - k];
                    String t = h + ":" + m; // hour, minutes, & time.
                    if (h.compareTo("24") < 0 && m.compareTo("60") < 0 && ans.compareTo(t) < 0) ans = t; // hour < 24; minute < 60; update result.
                }
            }
        }
        return ans;
    }

    public String largestTimeFromDigits(int[] arr) {
        List<int[]> variants = new ArrayList<>();
        boolean[] available = new boolean[4];
        Arrays.fill(available, true);
        getAllPossible(variants, new int[4], arr, available, 0);
        if (variants.isEmpty()) return "";
        int[] max = new int[]{-1,-1,-1,-1};
        for (int[] variant : variants) {
            if (!checkIfValid(variant)) continue;
           int i = 0;
           while (i != 3) {
               if (max[i] > variant[i]) break;
               if (max[i] < variant[i]) {
                   max = variant;
                   break;
               }
               i++;
           }
        }
        if (Arrays.equals(max, new int[]{-1, -1, -1, -1})) return "";
        return String.valueOf(max[0]) + max[1] + ":" + max[2] + max[3];
    }

    private boolean checkIfValid(int[] arr) {
        if (arr[0] > 2 || arr[1] > 9) return false;
        if (arr[0] == 2 && arr[1] > 3) return false;
        return arr[2] <= 5 && arr[3] <= 9;
    }

    private void getAllPossible(List<int[]> results, int[] current, int[] start, boolean[] available, int index) {
        if (index == 4) results.add(current);
        else {
            for (int i = 0; i < available.length; i++) {
                if (!available[i]) continue;
                current[index] = start[i];
                available[i] = false;
                getAllPossible(results, new int[]{current[0], current[1], current[2], current[3]}, start, available, index + 1);
                available[i] = true;
            }
        }
    }
}
