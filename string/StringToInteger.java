package LeetCode.string;

//https://leetcode.com/problems/string-to-integer-atoi/submissions/
public class StringToInteger {

    public static void main(String[] args) {
        StringToInteger stringToInteger = new StringToInteger();
        System.out.println(stringToInteger.myAtoiTwo("+0 123"));
    }

    public int myAtoiTwo(String s) {
        int pointer = 0, len = s.length();
        long ans = 0;
        boolean negative = false;
        while (pointer < len && s.charAt(pointer) == ' ') pointer++;
        if (pointer == len) return 0;
        if (s.charAt(pointer) == '-') negative = true;
        if (s.charAt(pointer) == '+' || s.charAt(pointer) == '-') pointer++;
        if (pointer == len) return 0;

        while (pointer < len && s.charAt(pointer) >= '0' && s.charAt(pointer) <= '9') {
            if (ans * 10 + s.charAt(pointer) - '0' > Integer.MAX_VALUE) return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            ans = ans * 10 + s.charAt(pointer) - '0';
            pointer++;
        }

        return (int) (negative ? -ans : ans);
    }

    public int myAtoi(String str) {
        final int len = str.length();
        if(len == 0){
            return 0;
        }
        int index = 0;
        while(index < len && str.charAt(index) == ' '){
            index++;
        }
        if(index == len){
            return 0;
        }
        char ch;
        boolean isNegative = (ch = str.charAt(index)) ==  '-';
        if(isNegative || ch == '+'){
            ++index;
        }
        final int maxLimit = Integer.MAX_VALUE / 10;
        int result = 0;
        while(index < len && isDigit(ch = str.charAt(index))){
            int digit = ch - '0';
            if(result > maxLimit || (result == maxLimit && digit > 7)){
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            result = (result * 10) + digit;
            ++index;
        }

        return isNegative ? -result : result;
    }

    private boolean isDigit(char ch){
        return ch >= '0' && ch <= '9';
    }
}
