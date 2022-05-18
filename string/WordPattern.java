package LeetCode.string;

public class WordPattern {

    public static void main(String[] args) {
        WordPattern wordPattern = new WordPattern();
        System.out.println(wordPattern.wordPattern("aaa", "a a"));
    }

    public boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ");
        if (arr.length != pattern.length()) return false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if ((pattern.charAt(i) == pattern.charAt(j)) != arr[i].equals(arr[j])) return false;
            }
        }
        return true;
    }
}
