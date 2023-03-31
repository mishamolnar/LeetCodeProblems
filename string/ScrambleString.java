package LeetCode.string;

public class ScrambleString {
    public boolean isScramble(String s1, String s2) {
        return isScramble(s1, s2, 0, s1.length());
    }

    private boolean isScramble(String s1, String s2, int start, int end) { //inclusive, exclusive
        if (start == end) {
            return false;
        } else if (start == end - 1) {
            return s1.charAt(start) == s2.charAt(start);
        } else if (start == end - 2) {
            s1 = s1.substring(start, end);
            s2 = s2.substring(start, end);
            return s1.equals(s2) || s1.equals(new StringBuilder(s2).reverse().toString());
        }
        int[] arr = new int[26];
        int counter = 0;
        for (int i = start; i < end - 1; i++) {
            int originalChar = s1.charAt(i) - 'a';
            arr[originalChar]++;
            if (arr[originalChar] == 1) {
                counter++;
            } else if (arr[originalChar] == 0) {
                counter--;
            }

            int scrambledChar = s2.charAt(i) - 'a';
            arr[scrambledChar]--;
            if (arr[scrambledChar] == -1) {
                counter++;
            } else if (arr[scrambledChar] == 0) {
                counter--;
            }
            if (counter == 0 && isScramble(s1, s2, start, i + 1) && isScramble(s1, s2, i + 1, end)) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(new ScrambleString().isScramble("abcdbdacbdac", "bdacabcdbdac"));
    }
}
