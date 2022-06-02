package LeetCode.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringsDifferByOneCharacter {
    public boolean differByOne(String[] dict) {
        HashSet<Long> set = new HashSet<>();
        long mod = (long) Math.pow(10, 20) + 7;

        int len = dict[0].length();
        long[] wordsHash = new long[dict.length];
        for (int i = 0; i < dict.length; i++) {
            for (int j = 0; j < len; j++) {
                wordsHash[i] = (wordsHash[i] * 26 + dict[i].charAt(j) - 'a') % mod;
            }
        }

        long base = 1;
        for (int i = len - 1; i >= 0; i--) {
            set.clear();
            for (int j = 0; j < dict.length; j++) {
                long newHash = (wordsHash[j] - base * (dict[j].charAt(i) - 'a')) % mod;
                if (set.contains(newHash)) return true;
                set.add(newHash);
            }
            base = base * 26 % mod;
        }
        return false;
    }

    private List<String> generate(String s) {
        StringBuilder sb = new StringBuilder(s);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            sb.replace(i, i + 1, "*");
            result.add(sb.toString());
            sb.replace(i, i + 1, String.valueOf(s.charAt(i)));
        }
        return result;
    }

    public static void main(String[] args) {
        StringsDifferByOneCharacter stringsDifferByOneCharacter = new StringsDifferByOneCharacter();
        System.out.println(stringsDifferByOneCharacter.generate("abcdf"));
        System.out.println(stringsDifferByOneCharacter.differByOne(new String[]{"aaaddb","aaaacd","aaacda","aaaaba","aaaccd"}));
    }
}
