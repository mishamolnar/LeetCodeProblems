package LeetCode.string;


//https://leetcode.com/problems/basic-calculator-ii/solution/
public class BasicCalculatorII {
        public int calculate(String s) {
            s = s.replace(" ", "");
            return parseExpression(s, new int[]{0});
        }

        private int parseExpression(String s, int[] pointer) {
            int res = parseTerm(s, pointer);
            while (pointer[0] < s.length()) {
                boolean add = s.charAt(pointer[0]++) == '+';
                int num = parseTerm(s, pointer);
                if (add) res += num;
                else res -= num;
            }
            return res;
        }

        private int parseTerm(String s, int[] pointer) {
            int res = parseFactor(s, pointer);
            while (pointer[0] < s.length() && (s.charAt(pointer[0]) == '*'
                    || s.charAt(pointer[0]) == '/')) {
                boolean mul = (s.charAt(pointer[0]++) == '*');
                int num  = parseFactor(s, pointer);
                if (mul) res *= num;
                else res /= num;
            }
            return res;
        }

        private int parseFactor(String s, int[] pointer) {
            int factor = 0;
            while (pointer[0] < s.length() && Character.isDigit(s.charAt(pointer[0]))) {
                factor *= 10;
                factor += (s.charAt(pointer[0]++) - '0');
            }
            return factor;
        }

    public static void main(String[] args) {
        BasicCalculatorII basicCalculatorII = new BasicCalculatorII();
        System.out.println(basicCalculatorII.calculate("3+2*2"));
    }
}
