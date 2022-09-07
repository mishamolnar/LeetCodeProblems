package LeetCode.string;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Map;

//https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
public class RemoveAllAdjacentDuplicatesInStringII {



    public String removeDuplicatesII(String s, int k) {
        Deque<Map.Entry<Character, Integer>> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (!stack.isEmpty() && stack.peek().getKey() == curr) {
                stack.push(Map.entry(stack.peek().getKey(), stack.poll().getValue() + 1));
                if (stack.peek().getValue() == k)
                    stack.pop();
            }
            else stack.push(Map.entry(curr, 1));
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty())
            res.append(String.valueOf(stack.peekLast().getKey()).repeat(stack.pollLast().getValue()));
        return res.toString();
    }

    public static void main(String[] args) {
        RemoveAllAdjacentDuplicatesInStringII remove = new RemoveAllAdjacentDuplicatesInStringII();
        System.out.println(remove.removeDuplicatesII("deeedbbcccbdaakk", 3));
    }


    public String removeDuplicates(String s, int k) {
        char[] arr = s.toCharArray();
        int[] counts = new int[s.length()];
        counts[0] = 1;
        int res = 1;
        for (int i = 1; i < arr.length; i++, res++) {
            arr[res] = arr[i];
            if (res > 0 && arr[i] == arr[res - 1]) {
                counts[res] = counts[res - 1] + 1;
            } else counts[res] = 1;
            if (counts[res] == k) res -= k;
        }
        return new String(arr, 0, res);
    }
}
