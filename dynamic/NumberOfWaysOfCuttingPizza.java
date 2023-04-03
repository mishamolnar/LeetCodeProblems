package LeetCode.dynamic;

import java.util.HashMap;
import java.util.Map;

public class NumberOfWaysOfCuttingPizza {
    private static final int MOD = 1_000_000_007;
    Map<String, Integer> memo;

    public int ways(String[] pizza, int k) {
        return 0;
    }


    //recurrence correct, but TLE,
    //complexity -
    public int waysRecurrence(String[] pizza, int k) {
        memo = new HashMap<>();
        boolean[][] arr = new boolean[pizza.length][pizza[0].length()];
        for (int i = 0; i < pizza.length; i++) {
            char[] buff = pizza[i].toCharArray();
            for (int j = 0; j < buff.length; j++) {
                arr[i][j] = buff[j] == 'A';
            }
        }
        return ways(arr, 0, 0, k - 1);
    }

    private int ways(boolean[][] arr, int i, int j, int left) {
        String args = String.format("%d,%d,%d", i, j, left);
        if (memo.containsKey(args)) {
            return memo.get(args);
        }
        if (left < 0 || i >= arr.length || j >= arr[0].length) {
            return 0;
        }
        if (left == 0) {
            return contains(arr, i, j, arr.length, arr[0].length) ? 1 : 0;
        }
        int res = 0;
        //horizontal
        int nextI = i + 1;
        while (nextI <= arr.length && !contains(arr, i, j, nextI, arr[0].length))
            nextI++;
        for (; nextI < arr.length; nextI++) {
            res += ways(arr, nextI, j, left - 1);
            res %= MOD;
        }
        //vertical
        int nextJ = j + 1;
        while (nextJ <= arr[0].length && !contains(arr, i, j, arr.length, nextJ))
            nextJ++;
        for (; nextJ < arr[0].length; nextJ++) {
            res+= ways(arr, i, nextJ, left - 1);
            res %= MOD;
        }
        memo.put(args, res);
        return res;
    }

    private boolean contains(boolean[][] arr, int i, int j, int x, int y) {
        for (int buffI = i; buffI < x; buffI++) {
            for (int buffJ = j; buffJ < y; buffJ++) {
                if (arr[buffI][buffJ]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new NumberOfWaysOfCuttingPizza().ways(new String[]{"A..","AAA","..."}, 3));
        System.out.println(new NumberOfWaysOfCuttingPizza().ways(new String[]{".A","AA","A."}, 3));

    }
}
