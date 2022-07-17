package LeetCode.string;

import java.util.HashMap;

// link https://leetcode.com/problems/minimum-window-substring/
public class MinimumWindowSubstring {






    //Input: s = "ADOBECODEBANC", t = "ABC"
    //Output: "BANC"
    public String minWindowTwo(String s, String t) {
        HashMap<Character, Integer> have = new HashMap<>();
        HashMap<Character, Integer> need = new HashMap<>();
        for (int i = 0; i < t.length(); i++)
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        int totalNeed = t.length(), totalHave = 0, resLen = Integer.MAX_VALUE, left = 0;
        String res = "";
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (have.getOrDefault(c, 0) < need.getOrDefault(c, 0)) totalHave++;
            have.put(c, have.getOrDefault(c, 0) + 1);
            while (totalHave >= totalNeed) {
                if (right - left + 1 < resLen) res = s.substring(left, right + 1);
                resLen = Math.min(resLen, right - left + 1);
                char toDelete = s.charAt(left++);
                if (have.get(toDelete) <= need.getOrDefault(toDelete, 0)) totalHave--;
                have.put(toDelete, have.get(toDelete) - 1);
            }
        }
        return res;
    }







    // sliding window problem
    // complexity time - O(n + s) and space - O(n)
    // totalHave - how many of needed characters are in current string
    // hashmaps - actual characters that we need
    // update totalHave only if we have added character from t and this is not extra character
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> have = new HashMap<>();
        HashMap<Character, Integer> need = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
            have.put(t.charAt(i), 0);
        }
        int left = 0;
        int totalHave = 0;
        int totalNeed = t.length();
        int leftEnd = 0;
        int rightEnd = 0;
        int minLength = Integer.MAX_VALUE;
        for (int right = 0; right < s.length(); right++) {
            if (!need.containsKey(s.charAt(right))) continue;
            char curr = s.charAt(right);
            int currentHave = have.get(curr) + 1;
            have.put(curr, currentHave);
            if (need.get(curr) >= currentHave) totalHave++;
            if (totalHave >= totalNeed) {
                if ((right - left + 1) < minLength ) {
                    minLength = right - left + 1;
                    rightEnd = right;
                    leftEnd = left;
                }
                while (totalHave >= totalNeed) {
                    if (!need.containsKey(s.charAt(left))) {
                        left++;
                        if ((right - left + 1)  < minLength && totalHave >= totalNeed) {
                            minLength = right - left + 1;
                            rightEnd = right;
                            leftEnd = left;
                        }
                        continue;
                    }
                    char toDelete = s.charAt(left);
                    if (have.get(toDelete) > need.get(toDelete)) {
                        have.put(toDelete, have.get(toDelete) - 1);
                    } else {
                        have.put(toDelete, have.get(toDelete) - 1);
                        totalHave--;
                    }
                    left++;
                    if ((right - left + 1)  < minLength && totalHave >= totalNeed) {
                        minLength = right - left + 1;
                        rightEnd = right;
                        leftEnd = left;
                    }
                }
            }
        }
        if (minLength == Integer.MAX_VALUE) return "";
        return s.substring(leftEnd, rightEnd + 1);
    }


    // sliding window problem
    // complexity time - O(n + s) and space - O(n)
    public String minWindowOptimized(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();//хешмапа зі всіма буквами які ми шукаємо і їх кількістю
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        int start = 0;
        int end = 0;
        int charTLeft = t.length(); // скільки залишилось шукомих літер
        int minStart = 0;
        int minLen = Integer.MAX_VALUE;

        while (end < s.length()) {
            char eChar = s.charAt(end); //теперішній символ
            if (map.containsKey(eChar)) {
                int count = map.get(eChar); //скільки таких самих символів ще потрібно
                if (count > 0) {
                    charTLeft--; // якщо цей символ був потрібний - зменшуємо кількість шукомих літер
                }
                map.put(eChar, count - 1); //зменшуємо кількість цього символу на 1
            }
            end++; //ітеруємось далі

            while (charTLeft == 0) { // якщо ми знайшли потрібну стрінгу
                if (minLen > end - start) { // апдейтимо старт і довжину, якщо теперішня стрінга менша за попередню
                    minLen = end - start;
                    minStart = start;
                }
                char sChar = s.charAt(start); //забираємо лівий символ поки стрінга не перестане бути валідною
                if (map.containsKey(sChar)) {
                    int count = map.get(sChar);
                    if (count == 0) {
                        charTLeft++; //обновляємо головну величину
                    }
                    map.put(sChar, count + 1); // обновляємо мапу
                }
                start++; // інкрементимо потрібне значення
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen); // якщо ми хоч раз обновляли довжину - повертаємо її, в інакшому разі ми не знаходили нічого валідного і повертаємо пусту стрінгу
    }


    public static void main(String[] args) {
        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        System.out.println(minimumWindowSubstring.minWindowTwo("cabwefgewcwaefgcf", "cae"));
    }
}
