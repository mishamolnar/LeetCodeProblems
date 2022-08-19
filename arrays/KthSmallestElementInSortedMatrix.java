package LeetCode.arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KthSmallestElementInSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int buff = k, count = 0, sum = 0;
        while (buff > 0) {
            buff -= (count + 1);
            count++;
            sum += count;
        }
        sum -= count;
        count--;
        List<Integer> list = new ArrayList<>();
        int i = Math.max(0, count - (matrix.length - 1)), j = Math.min(count, matrix.length - 1);
        buff = j;
        while (i <= buff) {
            list.add(matrix[i++][j--]);
        }
        list.sort(Comparator.naturalOrder());
        return list.get(k - sum);
    }
}
