package LeetCode.dynamic;

import java.util.Arrays;

public class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        //brute force - n2, get 1 envelope and check in which it can be placed

        //sort by one side, then another
        //then iterate all that are bigger then current
        //dp[j] = Max(dp[i] + 1, dp[j])
        Arrays.sort(envelopes, (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : - Integer.compare(a[1], b[1])); //sort in decreasing, so we cannot count
        int[] longestIncreasingSequence = new int[envelopes.length + 1]; //tracking second value, because first value is already sorted
        Arrays.fill(longestIncreasingSequence, Integer.MAX_VALUE);
        longestIncreasingSequence[0] = Integer.MIN_VALUE;
        int ans = 1;
        for (int i = 0; i < envelopes.length; i++) {
            int secondSide = envelopes[i][1];
            int firstBigger = binarySearch(longestIncreasingSequence, secondSide);
            longestIncreasingSequence[firstBigger] = Math.min(longestIncreasingSequence[firstBigger], secondSide);
            ans = Math.max(ans, firstBigger);
        }
        return ans;
    }


    private int binarySearch(int[] longestIncreasingSequence, int secondSide) { //returns the first element that is greater the second side
        int left = 0, right = longestIncreasingSequence.length;
        while (right - left > 1) {
            int mid = left + (right - left) / 2;
            if (longestIncreasingSequence[mid] >= secondSide) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }


    public static void main(String[] args) {
        System.out.println(new RussianDollEnvelopes().maxEnvelopes(new int[][]{{1,3}, {3,5}, {6,7}, {6,8}, {8,4}, {9,5}}));
        System.out.println(new RussianDollEnvelopes().maxEnvelopes(new int[][]{{1,1}, {1,1}, {1,1}}));
    }
}
