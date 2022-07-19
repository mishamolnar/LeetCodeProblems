package LeetCode.stack;

//https://leetcode.com/problems/basic-calculator/
public class BasicCalculatorSecondTry {
    public int calculate(String s) {
        s = s.replace(" ", "");
        return parseExpr(s, new int[]{0});
    }

    private int parseExpr(String s, int[] pointer) {
        int res = parseFactor(s, pointer);
        while (pointer[0] < s.length() && s.charAt(pointer[0]) != ')')  {
            boolean add = s.charAt(pointer[0]++) == '+';
            int buff = parseFactor(s, pointer);
            res = add ? res + buff : res - buff;
        }
        if (pointer[0] < s.length() && s.charAt(pointer[0]) == ')') pointer[0]++;
        return res;
    }

    private int parseFactor(String s, int[] pointer) {
        if (s.charAt(pointer[0]) == '(') {
            pointer[0]++;
            return parseExpr(s, pointer);
        }

        int res = 0;
        while (pointer[0] < s.length() &&
                 Character.isDigit(s.charAt(pointer[0]))) {
            res *= 10;
            res += s.charAt(pointer[0]++) - '0';
        }
        return res;
    }

    public static void main(String[] args) {
        BasicCalculatorSecondTry calc = new BasicCalculatorSecondTry();
        System.out.println(calc.calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}
