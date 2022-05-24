package LeetCode.greedy;

import java.util.Deque;
import java.util.LinkedList;

//https://leetcode.com/problems/remove-duplicate-letters/
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        Deque<Integer> stack = new LinkedList<>();
        boolean[] inStack = new boolean[26];
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++){
            lastIndex[s.charAt(i) - 'a'] = i; // останній індекс кожного символу
        }
        for (int i = 0; i < s.length(); i++) {
            int curr = s.charAt(i) - 'a';
            if (inStack[curr]) continue; //символ вже в стекові
            while (!stack.isEmpty() && stack.peek() > curr && lastIndex[stack.peek()] > i) {
                inStack[stack.pop()] = false; //якщо в стеку буква Б і ми добавляємо А, тоді ми витягаємо Б, але тільки якщо в нас є ще одна Б
            }
            stack.push(curr); //додаємо в стек теперішній символ
            inStack[curr] = true; // позначаємо що він в стекові
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append((char) (stack.pop() + 'a'));
        }
        return sb.reverse().toString();
    }
}
