package LeetCode.binarySearch;

public class GenericBinarySearch {

    public static void main(String[] args) {
        System.out.println(new GenericBinarySearch().leftMost(new int[]{1, 1, 2, 3, 4, 4, 4, 4, 5, 6, 7, 8}, 1));
    }

    private int leftMost(int[] arr, int target) {
        int left = -1; //excluded
        int right = arr.length; //answer
        while (right - left > 1) {
            int middle = left + (right - left) / 2;
            if (arr[middle] >= target) {
                right = middle;
            } else {
                left = middle;
            }
        }
        return right;
    }


    private int rightMost(int[] arr, int target) {
        int left = -1; //answer
        int right = arr.length; //excluded
        while (right - left > 1) {
            int middle = left + (right - left) / 2;
            if (arr[middle] <= target) {
                left = middle;
            } else {
                right = middle;
            }
        }
        return left;
    }


}
