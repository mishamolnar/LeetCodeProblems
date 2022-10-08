package LeetCode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestPrimeFraction {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> - Double.compare(a[0], b[0]));
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                pq.add(new double[]{arr[i] / (double) arr[j], arr[i], arr[j]});
                if (pq.size() > k) {
                    pq.poll();
                    break;
                }
            }
        }
        return new int[]{(int) pq.peek()[1], (int) pq.peek()[2]};
    }

    public int[] kthSmallestPrimeFractionII(int[] a, int k) {
        int n = a.length;
        // 0: numerator idx, 1: denominator idx
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int s1 = a[o1[0]] * a[o2[1]];
                int s2 = a[o2[0]] * a[o1[1]];
                return s1 - s2;
            }
        });
        for (int i = 0; i < n-1; i++) {
            pq.add(new int[]{i, n-1});
        }
        for (int i = 0; i < k-1; i++) {
            int[] pop = pq.remove();
            if (pop[1] - 1 > pop[0]) {
                pop[1]--;
                pq.add(pop);
            }
        }

        int[] peek = pq.peek();
        return new int[]{a[peek[0]], a[peek[1]]};
    }


    public static void main(String[] args) {
        KthSmallestPrimeFraction kthSmallestPrimeFraction = new KthSmallestPrimeFraction();
        System.out.println(kthSmallestPrimeFraction.kthSmallestPrimeFraction(new int[]{1,2,3,5}, 3));
    }
}
