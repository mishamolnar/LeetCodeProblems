package LeetCode.math;

import java.util.HashMap;

//https://leetcode.com/problems/hexspeak/
public class Hexspeak {
    public static void main(String[] args) {
        System.out.println(Integer.valueOf(String.valueOf(101), 16)); //101 -> 257
        System.out.println(Integer.toHexString(287)); //257 -> 101
    }

    public String toHexspeak(String num) {
        StringBuilder hex = new StringBuilder();
        hex.append(Long.toHexString(Long.parseLong(num)).toUpperCase());
        for (int i = 0; i < hex.length(); i++) {
            if (hex.charAt(i) == '1') hex.setCharAt(i, 'I');
            if (hex.charAt(i) == '0') hex.setCharAt(i, 'O');
            if (hex.charAt(i) > '1' && hex.charAt(i) < '9') return "ERROR";
        }
        return hex.toString();
    }

    public String toHexspeakUnboundedString(String num) {

        long n = Long.parseLong(num);
        HashMap<Integer, Character> map = new HashMap<>();
        map.put(0, 'O');
        map.put(1, 'I');
        map.put(10, 'A');
        map.put(11, 'B');
        map.put(12, 'C');
        map.put(13, 'D');
        map.put(14, 'E');
        map.put(15, 'F');

        String ans = "";

        while(n > 0){
            int rem = (int)(n % 16);
            if(rem > 1 && rem < 10) return "ERROR";
            n = n / 16;
            ans = map.get(rem) + ans;
        }

        return ans;

    }
}
