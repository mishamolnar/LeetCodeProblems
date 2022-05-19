package LeetCode.string;

//https://leetcode.com/problems/number-of-good-ways-to-split-a-string/submissions/
public class NumberOfGoodWaysToSplitAString {
    public static void main(String[] args) {
        NumberOfGoodWaysToSplitAString number = new NumberOfGoodWaysToSplitAString();
        System.out.println(number.numSplits("aacaba"));
    }

    public int numSplits(String s) {
        int[] leftPart = new int[27];
        int[] rightPart = new int[27];
        int total = 0, totalLeft = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int curr = s.charAt(i) - 'a';
            rightPart[curr]++;
            if (rightPart[curr] == 1) total++;
        }
        for (int i = 0; i < s.length(); i++) {
            int curr = s.charAt(i) - 'a';
            leftPart[curr]++;
            if (leftPart[curr] == 1) totalLeft++;
            rightPart[curr]--;
            if (rightPart[curr] == 0) total--;
            if (totalLeft == total) result++;
        }
        return result;
    }
}
