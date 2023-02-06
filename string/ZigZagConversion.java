package LeetCode.string;

import java.util.Arrays;

//https://leetcode.com/problems/zigzag-conversion/
public class ZigZagConversion {
    public static void main(String[] args) {
        ZigZagConversion zigZagConversion = new ZigZagConversion();
        System.out.println(zigZagConversion.convert("PAYPALISHIRING", 3));
    }

    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        char[] result = new char[s.length()];
        for (int i = 0, len = 0; i < numRows; i++) {
            for (int j = 0, k = i; k < s.length(); j++) {
                result[len++] = s.charAt(k);
                k += ((i == 0 || j % 2 ==0) && i != numRows - 1) ? 2 * (numRows - i - 1) : 2 * i;
            }
        }
        return String.valueOf(result);
    }



    public String convertTwo(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < sbs.length; i++) sbs[i] = new StringBuilder();
        int row = 0, diff = -1;
        for (char curr : s.toCharArray()) {
            if (row == 0 || row == numRows - 1) {
                diff = -diff;
            }
            sbs[row].append(curr);
            row += diff;
        }
        return Arrays.stream(sbs).
                reduce(new StringBuilder(), StringBuilder::append)
                .toString();

    }
}
