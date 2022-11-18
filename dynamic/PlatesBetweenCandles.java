package LeetCode.dynamic;

import java.util.Arrays;

public class PlatesBetweenCandles {
    public int[] platesBetweenCandles(String s, int[][] queries) {
           int toTheLeft = -1, sum = 0, len = s.length();
           int[] sums = new int[len];
           int[] leftClosest = new int[len];
           for (int i = 0; i < len; i++) {
               toTheLeft = s.charAt(i) == '|' ? i : toTheLeft;
               sum += s.charAt(i) == '*' ? 1 : 0;
               leftClosest[i] = toTheLeft;
               sums[i] = sum;
           }
           int[] rightClosest = new int[s.length()];
           int toTheRight = len;
           for (int i = len - 1; i >= 0; i--) {
               toTheRight = s.charAt(i) == '|' ? i : toTheRight;
               rightClosest[i] = toTheRight;
           }
           int[] res = new int[queries.length];
           for (int i = 0; i < queries.length; i++) {
               int leftBorder = rightClosest[queries[i][0]],
                       rightBorder = leftClosest[queries[i][1]];
               if (leftBorder == -1 || rightBorder == len || leftBorder > rightBorder) continue;
               res[i] = sums[rightBorder] - sums[leftBorder];
           }
           return res;
    }

    public static void main(String[] args) {
        PlatesBetweenCandles platesBetweenCandles = new PlatesBetweenCandles();
        System.out.println(Arrays.toString(platesBetweenCandles.platesBetweenCandles("***|**|*****|**||**|*", new int[][]{{1, 17}})));
    }
}
