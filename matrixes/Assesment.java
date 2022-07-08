package LeetCode.matrixes;

import java.util.Map;

public class Assesment {
    private static final Map<Character, Integer> mapForLetters = Map.of('M', 1000, 'D', 500, 'C', 100, 'L', 50, 'X', 10, 'V', 5, 'I', 1);
    private static final int[] nums = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] roman = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public static String StringChallenge(String str) {
        StringBuilder res = new StringBuilder();
        StringBuilder token = new StringBuilder("usxio6adc8");
        long input = calculate(str);
        for (int i = 0; i < nums.length; i++) {
            while (input > nums[i]) {
                res.append(roman[i]);
                input -= nums[i];
            }
        }
        res.reverse();
        token.reverse();
        res.append(":").append(token);
        return res.toString();
    }


    private static long calculate(String str) {
        long ans = 0;
        for (int i = 0; i < str.length(); i++) {
            ans += mapForLetters.get(str.charAt(i));
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(StringChallenge("XXXVVIIIIIIIIII"));
    }

}
