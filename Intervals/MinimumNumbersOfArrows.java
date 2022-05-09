package LeetCode.Intervals;

import java.util.Arrays;

// link - https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
public class MinimumNumbersOfArrows {
    public static void main(String[] args) {
        MinimumNumbersOfArrows minimumNumbersOfArrows = new MinimumNumbersOfArrows();
        System.out.println(minimumNumbersOfArrows.findMinArrowShots(new int[][]{{10,16},{2,8},{1,6},{7,12}}));
//        System.out.println(minimumNumbersOfArrows.findMinArrowShots(new int[][]{{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}}));
    }


    //time - O(n log n) space O(1)
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int rp = points[0][1]; //rp - right pointer - мінімальний із поточних правих кінців масиву (поточні масиви - ті які накладаються)
        int arrows = 1;
        for (int i = 1; i < points.length; i++) {
            if (rp < points[i][0]) { // наступний лівий кінець більший за найменший правий. Тому пускаєм стрілу)
                arrows++;
                rp = points[i][1];
            } else { // в інакшому випадку просто обновляємо rp
                rp = Math.min(rp, points[i][1]);
            }
        }
        return arrows;
    }
}
