package LeetCode.math;

import java.util.HashMap;

//https://leetcode.com/problems/fraction-to-recurring-decimal/
public class FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        long num = numerator;
        long den = denominator;
        if (num < 0 && den < 0) {
            num = -num;
            den = -den;
        } else if (num < 0 || den < 0) {
            sb.append("-");
            num = Math.abs(num);
            den = Math.abs(den);
        }
        HashMap<Long, Integer> map = new HashMap<>(); //[divider, remainder]
        boolean afterComa = false;
        while (num != 0) {
            long divider = num / den;
            long remainder = num % den;
            if (divider == 0 && !afterComa) {
                sb.append(sb.length() == 0 ? "0." : ".");
                afterComa = true;
            } else sb.append(divider);
            num = afterComa ? remainder * 10 : remainder;
            if (map.containsKey(num) && afterComa) {
                sb.replace(map.get(num), sb.length(), "(" + sb.substring(map.get(num)) + ")");
                return sb.toString();
            } else map.put(num, sb.length());
        }
        if (sb.toString().equals("-")) return "0";
        return sb.length() > 0 ? sb.toString() : "0";
    }

    public static void main(String[] args) {
        FractionToRecurringDecimal fractionToRecurringDecimal = new FractionToRecurringDecimal();
        System.out.println(fractionToRecurringDecimal.fractionToDecimal(-50, 8));
    }
}
