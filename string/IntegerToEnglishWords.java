package LeetCode.string;


//https://leetcode.com/problems/integer-to-english-words/submissions/
public class IntegerToEnglishWords {
    private final String[] belowTen = new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private final String[] belowTwenty = new String[] {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] belowHundred = new String[] {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        String res = "";
        if (num < 1000) res = helper(num);
        else if (num < 1000000) res = helper(num / 1000) + " Thousand " + helper(num % 1000);
        else if (num < 1000000000) res = helper(num / 1000000) + " Million " + helper(num % 1000000);
        else res = helper(num / 1000000000) + " Billion " + helper(num % 1000000000);
        return res.trim();
    }

    private String helper(int n) {
        StringBuilder sb = new StringBuilder();
        if (n >= 100) {
            sb.append(belowTen[n / 100]).append(" ").append("Hundred").append(" ");
            n %= 100;
        }
        if (n >= 20) {
            sb.append(belowHundred[n / 10]).append(" ");
            n %= 10;
        }
        if (n >= 10) {
            sb.append(belowTwenty[n - 10]).append(" ");
            return sb.toString();
        }
        if (n > 0) {
            sb.append(belowTen[n]).append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        IntegerToEnglishWords integerToEnglishWords = new IntegerToEnglishWords();
        System.out.println(integerToEnglishWords.helper(1));
    }
}
