package LeetCode.string;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/find-all-anagrams-in-a-string/
public class FindAllAnagramsInString {

    public List<Integer> findAnagrams(String s, String p) {
        int[] target = new int[26], window = new int[26];
        for (int i = 0; i < p.length(); i++) target[p.charAt(i) - 'a']++;
        List<Integer> res = new ArrayList<>();
        int left = 0, inWindow = 0, pLen = p.length();
        for (int i = 0; i < s.length(); i++) {
            int curr = s.charAt(i) - 'a';
            if (target[curr] != 0) {
                if (window[curr] < target[curr]) inWindow++; //якщо тільки в нас стає менше конкретної букви ніж потрібно - зменшуємо  каунтер
                window[curr]++; //інкрементимо змінну в масиві
            }
            if (inWindow == pLen) res.add(left);
            if (i - left + 1 == pLen) {
                if (window[s.charAt(left) - 'a'] > 0) {
                    if (window[s.charAt(left) - 'a'] <= target[s.charAt(left) - 'a']) inWindow--;
                    window[s.charAt(left) - 'a']--;
                }
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FindAllAnagramsInString find = new FindAllAnagramsInString();
        System.out.println(find.findAnagrams("cbaebabacd", "abc"));
    }
}
