package LeetCode.arrays;

public class PeakIndexInMountainArray {
    public static void main(String[] args) {
        PeakIndexInMountainArray peakIndexInMountainArray = new PeakIndexInMountainArray();
        System.out.println(peakIndexInMountainArray.peakIndexInMountainArray(new int[]{3,5,3,2,0}));
    }

    public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid > 0 && mid < arr.length - 1 && arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) return mid;
            if (mid > 0 && arr[mid] > arr[mid - 1]) left = mid + 1;
            else right = mid - 1;
        }
        return ((left < arr.length && arr[left] > arr[left + 1]) && (left > 0 && arr[left] > arr[left - 1])) ? left : left + 1;
    }
}
