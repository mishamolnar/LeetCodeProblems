package LeetCode.sorting;

import java.util.Arrays;

//https://leetcode.com/problems/the-number-of-weak-characters-in-the-game/
public class NumberOfWeakCharactersInGame {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
        int res = 0, max = 0, currMax = 0, len = properties.length - 1;
        for (int i = properties.length - 1; i >= 0; i--) {
            if (i < len && properties[i][0] < properties[i + 1][0])
                currMax = max;
            if (properties[i][1] < currMax && properties[i][0] < properties[len][0])
                res++;
            max = Math.max(properties[i][1], max);
        }
        return res;
    }
}
