package LeetCode.string;

import java.math.BigInteger;

public class DecodedStringAtIndex {
    public String decodeAtIndex(String s, int k) {
        //brute force - read string, parse number if occurs, add all this strings
        k--;
        int start = 0, totalLength = 0;
        while (start < s.length()) {
            String word = parseString(s, start);
            start += word.length();
            String parseNumber = parseNumber(s, start);
            start += parseNumber.length();
            long count = parseNumber.length() == 0 ? 0 : new BigInteger(parseNumber).min(BigInteger.valueOf(Long.MAX_VALUE)).longValue();
            if  (totalLength + word.length() > k) {
                return String.valueOf(word.charAt(k - totalLength));
            } else if ((totalLength + word.length()) * count > k) {
                return decodeAtIndex(s, k % (totalLength + word.length()) + 1);
            }
            totalLength += word.length();
            totalLength *= count;
        }
        return "failed";
    }

    private String parseString(String s, int start) {
        int end = start;
        while (end < s.length() && Character.isAlphabetic(s.charAt(end)))
            end++;
        return s.substring(start, end);
    }

    private String parseNumber(String s, int start) {
        int end = start;
        while (end < s.length() && Character.isDigit(s.charAt(end)))
            end++;
        return s.substring(start, end);
    }

    public static void main(String[] args) {
        System.out.println(new DecodedStringAtIndex().decodeAtIndex("ha22", 5));
    }

}
