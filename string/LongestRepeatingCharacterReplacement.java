package LeetCode.string;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

//time, space O(n)
// link -
public class LongestRepeatingCharacterReplacement {

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
        System.out.println(longestRepeatingCharacterReplacement.characterReplacementWithMaxFrequency("AABABBA", 1));
    }
}
