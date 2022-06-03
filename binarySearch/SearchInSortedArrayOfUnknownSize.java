package LeetCode.binarySearch;

//https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/
public class SearchInSortedArrayOfUnknownSize {
    public int search(ArrayReader reader, int target) {
        int left = 0, right = getLength(reader);
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int val = reader.get(mid);
            if (val == target) return mid;
            if (val > target) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }

    private int getLength(ArrayReader reader) {
        int left = 0, right = 100000;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int val = reader.get(mid);
            if (val == Integer.MAX_VALUE) {
                right = mid - 1;
            } else left = mid + 1;
        }
        return right;
    }


    // This is ArrayReader's API interface.
    // You should not implement it, or speculate about its implementation
    interface ArrayReader {
        public int get(int index);
    }

}
