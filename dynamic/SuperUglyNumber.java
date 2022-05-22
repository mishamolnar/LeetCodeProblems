package LeetCode.dynamic;

import java.util.HashMap;
import java.util.PriorityQueue;

public class SuperUglyNumber {

    public static void main(String[] args) {
       SuperUglyNumber superUglyNumber = new SuperUglyNumber();
        System.out.println(superUglyNumber.nthSuperUglyNumber(67, new int[]{2, 997}));
    }

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] res = new int[n];
        res[0] = 1;
        int[] indexes = new int[primes.length];

        for (int i = 1; i < n; i++) {
            res[i] = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                res[i] = Math.min(res[i], primes[j] * res[indexes[j]]);
            }

            for (int j = 0; j < primes.length; j++) {
                while (primes[j] * res[indexes[j]] <= res[i]  && indexes[j] < n - 1) {
                    indexes[j]++;
                }
            }
        }
        return res[n - 1];
    }
}
