package LeetCode.binarySearch;

//
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 < len2) return findMedianSortedArrays(nums2, nums1); //len2 is always smaller

        int left = 0, right = len2 - 1, half = (len1 + len2) / 2, total = len1 + len2;
        while (true) {
            int mid2 = Math.floorDiv(left + right, 2);
            int mid1 = half - mid2 - 2; //zero index thats why 2

            int mid1Left = mid1 < 0 ? Integer.MIN_VALUE : nums1[mid1];
            int mid1Right = mid1 + 1 == nums1.length ? Integer.MAX_VALUE : nums1[mid1 + 1];
            int mid2Left = mid2 < 0 ? Integer.MIN_VALUE : nums2[mid2];
            int mid2Right = mid2 + 1 == nums2.length ? Integer.MAX_VALUE : nums2[mid2 + 1];

            if (mid1Left <= mid2Right && mid2Left <= mid1Right) {
                if (total % 2 == 1) {
                    return Math.min(mid1Right, mid2Right);
                } else return (double) (Math.max(mid1Left, mid2Left) + Math.min(mid2Right, mid1Right)) / 2;
            } else if (mid1Left > mid2Right) {
                right = mid2  - 1;
            } else {
                left = mid2 + 1;
            }
        }
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays median = new MedianOfTwoSortedArrays();
        System.out.println(median.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
    }

}
