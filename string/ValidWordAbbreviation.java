package LeetCode.string;

//https://leetcode.com/problems/valid-word-abbreviation/submissions/
public class ValidWordAbbreviation {


    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0;
        while (i < word.length() && j < abbr.length()) {
            if (word.charAt(i) == abbr.charAt(j)) {
                i++;
                j++;
                continue;
            }
            if (abbr.charAt(j) <= '0' || abbr.charAt(j) > '9') return false;
            int start = j;
            while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) j++;
            i += Integer.parseInt(abbr.substring(start, j));
        }
        return i == word.length() && j == abbr.length();
    }

    public static void main(String[] args) {
        ValidWordAbbreviation validWordAbbreviation = new ValidWordAbbreviation();
        System.out.println(validWordAbbreviation.validWordAbbreviation("internationalization", "i12iz4n"));
    }
}
