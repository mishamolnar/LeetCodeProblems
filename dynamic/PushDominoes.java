package LeetCode.dynamic;

import java.util.Arrays;

public class PushDominoes {
    //.L.R...LR..L..
    //LL.RR.LLRRLL..
    public String pushDominoesII(String dominoes) {
        int N = dominoes.length();
        int[] indexes = new int[N+2];
        char[] symbols = new char[N+2];
        int len = 1;
        indexes[0] = -1;
        symbols[0] = 'L';

        for (int i = 0; i < N; ++i)
            if (dominoes.charAt(i) != '.') {
                indexes[len] = i;
                symbols[len++] = dominoes.charAt(i);
            }

        indexes[len] = N;
        symbols[len++] = 'R';

        char[] ans = dominoes.toCharArray();
        for (int index = 0; index < len - 1; ++index) {
            int i = indexes[index], j = indexes[index+1];
            char x = symbols[index], y = symbols[index+1];
            if (x == y) {
                for (int k = i+1; k < j; ++k)
                    ans[k] = x;
            } else if (x > y) { // RL
                for (int k = i+1; k < j; ++k)
                    ans[k] = k-i == j-k ? '.' : k-i < j-k ? 'R' : 'L';
            }
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sd = sb.append("asdf");

        return String.valueOf(ans);
    }


    public String pushDominoes(String dominoes) {
        //LL, RR, RL, LR
        int[] indexes = new int[dominoes.length() + 2];
        char[] chars = new char[dominoes.length() + 2];
        chars[0] = 'L';
        indexes[0] = -1;
        int len = 1;
        for (int i = 0; i < dominoes.length(); i++) {
            if (dominoes.charAt(i) == '.')
                continue;
            chars[len] = dominoes.charAt(i);
            indexes[len++] = i;
        }
        chars[len] = 'R';
        indexes[len] = dominoes.length();

        char[] res = dominoes.toCharArray();
        for (int i = 0; i < len; i++) {
            char leftChar = chars[i], rightChar = chars[i + 1];
            int leftIndex = indexes[i], rightIndex = indexes[i + 1];
            if (leftChar == rightChar)
                Arrays.fill(res, leftIndex + 1, rightIndex, leftChar);
            else if (leftChar == 'R' && rightChar == 'L') {
                for (int j = leftIndex + 1; j < rightIndex; j++) {
                    res[j] = j - leftIndex == rightIndex - j ? '.' :
                            j - leftIndex < rightIndex - j ? 'R' : 'L';
                }
            }
        }
        return new String(res);
    }


    public static void main(String[] args) {
        PushDominoes pushDominoes = new PushDominoes();
        System.out.println(pushDominoes.pushDominoes(".L.R...LR..L.."));
        System.out.println(pushDominoes.pushDominoes("RR.L"));
    }

}
