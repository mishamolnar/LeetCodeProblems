package LeetCode.string;

import java.util.Stack;

//https://leetcode.com/problems/decode-string/
public class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder cur = new StringBuilder();
        int k = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                k = k * 10 + (s.charAt(i) - '0');
            } else if (s.charAt(i) == '[') {
                strStack.add(cur);
                nums.add(k);
                k = 0;
                cur = new StringBuilder();
            } else if (s.charAt(i) == ']') {
                StringBuilder buff = cur;
                cur = strStack.pop();
                cur.append(buff.toString().repeat(nums.pop()));
            } cur.append(s.charAt(i));
        }
        return cur.toString();
    }


    public static void main(String[] args) {
        DecodeString decodeString = new DecodeString();
        System.out.println(decodeString.decodeString("2[abc]3[cd]ef"));
    }
}
