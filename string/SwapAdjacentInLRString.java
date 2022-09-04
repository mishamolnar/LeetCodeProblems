package LeetCode.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;

public class SwapAdjacentInLRString {

    public boolean findSubarrays(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i < nums.length; i++) {
            if (set.contains(nums[i] + nums[i -1]))
                return true;
            set.add(nums[i] + nums[i - 1]);
        }
        return false;
    }
    public boolean canTransform(String start, String end) {
        int ePointer = 0;
        for (int sPointer = 0; sPointer < end.length(); sPointer++) {
            char curr = start.charAt(sPointer);
            if (curr == 'R') {
                while (ePointer < end.length()) {
                    char endChar = end.charAt(ePointer++);
                    if (endChar == 'L')
                        return false;
                    if (endChar == 'R')
                        break;
                }
            } else if (curr == 'L') {
                while (ePointer <= sPointer) {
                    char endChar = end.charAt(ePointer++);
                    if (endChar == 'L')
                        break;
                    if (endChar == 'R')
                        return false;
                }
            }
        }
        for (; ePointer < end.length(); ePointer++) {
            if (end.charAt(ePointer) != 'X')
                return false;
        }
        return true;
    }

    private void swap(char[] arr, int i, int j) {
        char buff = arr[i];
        arr[i] = arr[j];
        arr[j] = buff;
    }

    public boolean isStrictlyPalindromic(int n) {
        for (int base = 2; base <= n - 2; base++) {
            if (!isPalindrome(Integer.toString(Integer.parseInt(String.valueOf(n), 10), base)))
                return false;
        }
        return true;
    }

    public boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2 + 1; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
        }
        return true;
    }

    public int maximumRows(int[][] mat, int cols) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 0; i < mat.length; i++) {
            pq.add(new int[]{Arrays.stream(mat[i]).sum(), i});
        }
        HashSet<Integer> columns = new HashSet<>();
        int ans = 0;
        while (columns.size() <= cols && !pq.isEmpty()) {
            int row = pq.poll()[1];
            for (int i = 0; i < mat[row].length; i++) {
                if (mat[row][i] == 1)
                    columns.add(i);
            }
            if (columns.size() <= cols)
                ans++;
        }
        return ans;
    }


    public static void main(String[] args) {
        SwapAdjacentInLRString swapAdjacentInLRString = new SwapAdjacentInLRString();
        System.out.println(swapAdjacentInLRString.maximumRows(new int[][]{{0, 0, 0}, {1, 0, 1}, {0, 1, 1}, {0, 0, 1}}, 2));
    }
}
