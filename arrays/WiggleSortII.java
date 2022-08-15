package LeetCode.arrays;

public class WiggleSortII {
    public void wiggleSort(int[] nums) {
        int median = findKthLargestSelect(nums, (nums.length + 1) / 2);
        int n = nums.length;

        int left = 0, i = 0, right = n - 1;

        while (i <= right) {

            if (nums[newIndex(i,n)] > median) {
                exch(nums, newIndex(left++,n), newIndex(i++,n));
            }
            else if (nums[newIndex(i,n)] < median) {
                exch(nums, newIndex(right--,n), newIndex(i,n));
            }
            else {
                i++;
            }
        }


    }

    private int newIndex(int index, int n) {
        return (1 + 2*index) % (n | 1);
    }


    public int findKthLargestSelect(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        k = nums.length - k;
        while (true) {
            int p = quickSelect(nums, left, right);
            if (p == k) return nums[p];
            if (p > k) right = p - 1;
            else left = p + 1;
        }
    }

    private int quickSelect(int[] nums, int left, int right) {
        int pivot = nums[right];
        for (int i = left; i < right; i++) {
            if (nums[i] < pivot) {
                exch(nums, left, i);
                left++;
            }
        }
        exch(nums, left, right);
        return left;
    }


    private static void exch(int[] a, int i, int j) {
        if (i == j) return;
        int buff = a[i];
        a[i] = a[j];
        a[j] = buff;
    }
}
