package LeetCode.string;

import java.util.stream.Stream;

//https://leetcode.com/problems/multiply-strings/
public class MultiplyStrings {
    public static void main(String[] args) {
        MultiplyStrings multiplyStrings = new MultiplyStrings();
//        System.out.println(multiplyStrings.multiplyByOne("999", 6));
//        System.out.println(multiplyStrings.add("0", "1234"));

        System.out.println(multiplyStrings.multiplyFromComments("123", "456"));
//        System.out.println(Integer.valueOf('5' - '0'));
    }


    //link - https://leetcode.com/problems/multiply-strings/discuss/17605/Easiest-JAVA-Solution-with-Graph-Explanation
    public String multiplyFromComments(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];

        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];

                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public String multiply(String num1, String num2) {
        String result = "0";
        for (int i = 0; i < num2.length(); i++) {
            String buff = multiplyByOne(num1, num2.charAt(i) - '0');
            result = String.format("%s0", add(buff, result));
        }
        if (allDigitsZero(result)) return "0";
        return result.length() > 1 ? result.substring(0, result.length() - 1) : result;
    }

    private String multiplyByOne(String num, int last) {
        int carry = 0;
        StringBuilder result = new StringBuilder();
        for (int i = num.length() - 1; i >= 0; i--) {
            int buff = (num.charAt(i) - '0') * last + carry;
            if (buff > 9) {
                carry = buff / 10;
                buff %= 10;
            } else carry = 0;
            result.append(buff);
        }
        if (carry != 0) result.append(carry);
        return result.reverse().toString();
    }

    private String add(String num1, String num2) {
        int carry = 0, right1 = num1.length() - 1, right2 = num2.length() - 1;
        StringBuilder result = new StringBuilder();
        while (right1 >= 0 || right2 >= 0) {
            int buff = (right1 >= 0 ? num1.charAt(right1--) - '0' : 0) + (right2 >= 0 ? num2.charAt(right2--) - '0' : 0) + carry;
            if (buff > 9) {
                carry = buff / 10;
                buff %= 10;
            } else carry = 0;
            result.append(buff);
        }
        if (carry != 0) result.append(carry);
        return result.reverse().toString();
    }

    private boolean allDigitsZero(String num) {
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) != '0') return false;
        }
        return true;
    }
}
