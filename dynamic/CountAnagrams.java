package LeetCode.dynamic;

import java.math.BigInteger;

public class CountAnagrams {
    private static final int MOD = 1_000_000_007;
    private BigInteger[] factorials;

    public int countAnagrams(String s) {
        factorials = new BigInteger[s.length()];
        String[] words = s.split(" ");
        BigInteger res = BigInteger.ONE;
        for (String word : words) {
            res = res.multiply(countAnagramsOfTheWord(word));
        }
        res = res.divideAndRemainder(BigInteger.valueOf(MOD))[1];
        return res.intValue();
    }

    private BigInteger countAnagramsOfTheWord(String word) {
        int[] chars = new int[26];
        for (char ch : word.toCharArray()) {
            chars[ch - 'a']++;
        }
        BigInteger res = factorial(word.length());
        for (int occurrence : chars) {
            res = res.divide(factorial(occurrence));
        }
        return res;
    }

    public BigInteger factorial(int n) {
        if (n == 0) {
            return BigInteger.ONE;
        } else if (factorials[n] != null) {
            return factorials[n];
        } else {
            factorials[n] = BigInteger.valueOf(n).multiply(factorial(n - 1));
            return factorials[n];
        }
    }

    public static void main(String[] args) {
        System.out.println(new CountAnagrams().countAnagrams("too hot"));
    }
}
