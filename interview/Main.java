package LeetCode.interview;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.reverse("abcde"));
        int[] arr = {2, 5, 0, -7, 11, 22};
        System.out.println(main.checkIfSumCanBeZero(arr));
        int[] sortedArr = {0, 1, 2, 3, 4, 5, 6, 7};
        System.out.println(main.findIndex(sortedArr, 8));
    }

    //0, 1, 2,3, 4, 5, 6
    //

    private int findIndex(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] > target) {
                right = mid - 1;
            } else left = mid + 1;
        }
        return -1;
    }

    private boolean checkIfSumCanBeZero(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr) {
            if (set.contains(-i)) return true;
            set.add(i);
        }
        return false;
    }


    private String reverse(String s) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length / 2; i++) {
            swap(arr, i, arr.length - i - 1);
        }
        return new String(arr);
    }

    private void swap(char[] arr, int i, int j) {
        char buff = arr[i];
        arr[i] = arr[j];
        arr[j] = buff;
    }
}
