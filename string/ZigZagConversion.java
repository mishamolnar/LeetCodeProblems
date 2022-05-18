package LeetCode.string;

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
}
