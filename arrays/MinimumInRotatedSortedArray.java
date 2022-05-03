package LeetCode.arrays;


//link - https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/submissions/
public class MinimumInRotatedSortedArray {

    // time - O(n)
    // - мінімум там де є перелом, а де саме перелом ми можемо визначити подивившись чи середина більша за початок
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (nums[left] > nums[right]) { //шукаємо поки масив "rotated"
            int mid = left + (right - left) / 2;
            if (nums[mid] >= nums[left]) { // якщо права частина відсортована - то йдемо вліво (якщо масив повністю відсортований і мінімальний елемент зліва - то ми сюди не попадем)
                left = mid + 1;
            } else right = mid; // якщо ні - то йдемо дивитись вправо, бо десь там перелом
        }
        return nums[left];
    }

    public int binarySearch(int[] nums, int number) {
        int left = 0;
        int right = nums.length - 1;
        while (right > left) {
            int mid = left + (right - left) / 2;
            if (number > nums[mid]) {
                left = mid + 1;
            } else if (number < nums[mid]) {
                right = mid;
            } else if (number == nums[mid]) {
                return mid;
            }
        }
        return nums[left] == number ? left : -1;
    }

    public static void main(String[] args) {
        MinimumInRotatedSortedArray minimumInRotatedSortedArray = new MinimumInRotatedSortedArray();
        System.out.println(minimumInRotatedSortedArray.findMin(new int[]{4, 5, 7, 8, 9, 1, 2}));

    }
}
