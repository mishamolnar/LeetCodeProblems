package LeetCode.string;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

//time, space O(n)
// link -
public class LongestRepeatingCharacterReplacement {

    public int characterReplacementTwo(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxFreq = 0, res = 0, left = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int freq = map.getOrDefault(c, 0) + 1;
            maxFreq = Math.max(maxFreq, freq);
            map.put(c, freq);
            while (i - left + 1 - maxFreq > k) {
                char toDelete = s.charAt(left++);
                map.put(toDelete, map.get(toDelete) - 1);
            }
            res = Math.max(i - left + 1, res);
        }
        return res;
    }

    public int characterReplacementSecondTry(String s, int k) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int left = 0, maxFreq = 0, result = 0;
        for (int i = 0; i < s.length(); i++) {
            hashMap.put(s.charAt(i), hashMap.getOrDefault(s.charAt(i), 0) + 1);
            while (i - left - Collections.max(hashMap.values()) >= k) {
                hashMap.put(s.charAt(left), hashMap.get(s.charAt(left)) - 1);
                left++;
            }
            result = Math.max(result, i - left + 1);
        }
        return result;
    }


    // sliding window - завжди валідна стрінга між  left i right
    public int characterReplacement(String s, int k) {
        int left = 0; //ліва частина sliding window
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int result = 0;
        for (int right = 0; right < s.length(); right++) { // right - права частина sliding window
            char curr = s.charAt(right);
            hashMap.put(curr, hashMap.getOrDefault(curr, 0) + 1);
            while ((right - left + 1) - Collections.max(hashMap.values()) > k) { //якщо потрібно - рухаємо ліву частину
                hashMap.put(s.charAt(left), hashMap.get(s.charAt(left)) - 1);
                left++;
            }
            result = Math.max(result, (right - left + 1));
        }
        return result;
    }

    public int characterReplacementWithMaxFrequency(String s, int k) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int left = 0;
        int result = 0;
        int maxFreq = 0;
        for (int right = 0; right < s.length(); right++) {
            char curr = s.charAt(right);
            hashMap.put(curr, hashMap.getOrDefault(curr, 0) + 1);
            maxFreq = Math.max(maxFreq, hashMap.get(curr)); //в цьому випадку в нас може бути неправильна величина maxFreq, але це ок,
            // адже ми оновлюємо максимальне значення результату тільки з оновленим значенням maxFreq
            while ((right - left + 1) - maxFreq > k) {
                hashMap.put(s.charAt(left), hashMap.get(s.charAt(left)) - 1);
                left++;
            }
            result = Math.max(result, (right - left + 1));
        }
        return result;
    }

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement longestRepeatingCharacterReplacement = new LongestRepeatingCharacterReplacement();
        System.out.println(longestRepeatingCharacterReplacement.characterReplacementTwo("AABABBA", 1));
    }
}
