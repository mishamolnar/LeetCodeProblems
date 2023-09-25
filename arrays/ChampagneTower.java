package LeetCode.arrays;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.Queue;

import static java.util.Map.*;

public class ChampagneTower {

    public double champagneTowerOptimal(int poured, int query_row, int query_glass) {
        double[][] pouredCounter = new double[100][100];
        pouredCounter[0][0] = poured;
        for (int row = 0; row < 100; row++) {
            for (int column = 0; column <= row; column++) {
                double next = (pouredCounter[row][column] - 1) / 2;
                if (next > 0 && row < 99) {
                    pouredCounter[row + 1][column] += next;
                    pouredCounter[row + 1][column + 1] += next;
                }
            }
        }
        return Math.min(1, pouredCounter[query_row][query_glass]);
    }

    public double champagneTower(int poured, int query_row, int query_glass) { //naive, poured complexity
        double[][] curr = new double[100][100];
        Queue<Map.Entry<int[], Double>> queue = new ArrayDeque<>();
        queue.add(entry(new int[]{0, 0}, 1.0));
        for (int i = 0; i < poured; i++) {
            Queue<Map.Entry<int[], Double>> next = new ArrayDeque<>();
            while (!queue.isEmpty()) {
                Entry<int[], Double> entry = queue.poll();
                int[] cell = entry.getKey();
                double flow = entry.getValue();
                curr[cell[0]][cell[1]] += flow;
                if (cell[0] < 99 && curr[cell[0]][cell[1]] >= 1.0) {
                    curr[cell[0] + 1][cell[1]] += (curr[cell[0]][cell[1]] - 1) / 2;
                    curr[cell[0] + 1][cell[1] + 1] += (curr[cell[0]][cell[1]] - 1) / 2;
                    next.add(entry(new int[]{cell[0] + 1, cell[1]}, flow / 2));
                    next.add(entry(new int[]{cell[0] + 1, cell[1] + 1}, flow / 2));
                } else next.add(entry);
            }
            queue = next;
        }
        return curr[query_row][query_glass];
    }

    public static void main(String[] args) {
        System.out.println(new ChampagneTower().champagneTowerOptimal(2, 1, 1));
    }
}
