package LeetCode.string;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/rearrange-string-k-distance-apart/
public class RearrangeStringKDistanceApart {

    //O(n) time complexity
    public String rearrangeString(String s, int k) {
        Map<Character, Integer> count = new HashMap<>();
        Map<Character, Integer> last = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++)
            count.put(s.charAt(i), count.getOrDefault(s.charAt(i), 0) + 1);
        while (count.size() > 0) {
            int buff = sb.length(), max = Integer.MIN_VALUE;
            char curr = '!';
            for (Character c : count.keySet()) {
                if (!last.containsKey(c) || buff - last.get(c) >= k) { // визначаємо символ який треба найбільше раз вставити, з тих які ми можемо зараз вставити
                    if (count.get(c) > max) {
                        max = count.get(c);
                        curr = c;
                    }
                }
            }
            if (curr == '!') return "";
            sb.append(curr); //вставляємо його
            last.put(curr, buff);
            count.put(curr, count.get(curr) - 1);
            if (count.get(curr) == 0) count.remove(curr);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        RearrangeStringKDistanceApart rearrange = new RearrangeStringKDistanceApart();
        System.out.println(rearrange.rearrangeString("aabbcc", 3));
    }
}
