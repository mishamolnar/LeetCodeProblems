package LeetCode.myImpls;

import java.util.Arrays;

public class QuickSort {
    private int[] sort(int[] arr) {
      return quicksort(arr, 0, arr.length - 1);
    }

    private int[] quicksort(int[] arr, int start, int end) {
        if (start < end) {
            int middle = partition(arr, start, end);
            quicksort(arr, start, middle - 1);
            quicksort(arr, middle + 1, end);
        }
        return arr;
    }

    private int partition(int[] arr, int start, int end) {
        int pivot = arr[end], lower = start;
        for (int upper = start; upper < end; upper++) {
            if (arr[upper] <= pivot) {
                swap(arr, lower, upper);
                lower++;
            }
        }
        swap(arr, lower, end);
        return lower;
    }

    private void swap(int[] arr, int a, int b) {
        int buff = arr[a];
        arr[a] = arr[b];
        arr[b] = buff;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new QuickSort().sort(new int[]{5,1,1,2,0,0})));
    }
}
