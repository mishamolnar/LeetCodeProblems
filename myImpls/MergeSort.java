package LeetCode.myImpls;

import java.util.Arrays;

// time - O(n log(n)) space - n
public class MergeSort {
    private static int[] aux;

    public static void main(String[] args) {
        int[] a = new int[] {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        sortWithRecursion(a);
        System.out.println(Arrays.toString(a));
    }

    public static void sortWithRecursion(int[] a) {
        aux = new int[a.length];
        sortWithRecursion(a, 0, a.length - 1);
    }

    public static void sortWithRecursion(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo)/2;
        sortWithRecursion(a, lo, mid);
        sortWithRecursion(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    public static void sort(int[] a) {
        int n = a.length;
        aux = new int[a.length];
        for (int sz = 1; sz < n; sz = sz + sz) {
            for (int lo = 0; lo < n - sz; lo += sz + sz) {
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, n - 1));
            }
        }
    }

    public static void merge(int[] a, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;

        // copy from a[] to aux[]
        if (hi + 1 - lo >= 0) System.arraycopy(a, lo, aux, lo, hi + 1 - lo);

        for (int k = lo; k <= hi; k++) { // merge back to a[]
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (aux[j] < aux[i]) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }
}
// sz - subarray size can be 1, 2, 4, 8
// lo - subarray index, can be 0, 2, 4, 6, 8. then 0, 4. then 0