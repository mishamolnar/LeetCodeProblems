package LeetCode.string;

import java.util.*;

//https://leetcode.com/problems/palindrome-permutation-ii/solution/
public class PalindromePermutationII {

    public static void main(String[] args) {
        PalindromePermutationII palindromePermutationII = new PalindromePermutationII();
        System.out.println(palindromePermutationII.generatePalindromes("aabb"));
    }

    public List<String> generatePalindromes(String s) {
        int[] arr = new int[27];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++; //counting characters
        }
        char single = '!';
        HashMap<Character, Integer> available = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) continue;
            if (arr[i] % 2 == 0) {
                available.put((char) (i + 'a'), arr[i] / 2); //adding characters to hashmap
            }
            else if (single == '!') {
                single = (char) (i + 'a');
                if (arr[i] - 1 > 1) available.put((char) (i + 'a'), (arr[i] - 1) / 2); //dealing with odd occurrences of a character
            }
            else return Collections.emptyList();
        }
        List<StringBuilder> res = new ArrayList<>();
        backtrack(res, available, new StringBuilder(), '!');
        List<String> output = new ArrayList<>();
        for (StringBuilder s1 : res) {
            output.add(s1.toString() + (single != '!' ? single : "") + s1.reverse().toString());
        }
        return output;
    }

    private void backtrack(List<StringBuilder> res, HashMap<Character, Integer> available, StringBuilder curr, Character toRemove) { //backtracking
        available.put(toRemove, available.getOrDefault(toRemove, 1) - 1);
        if (available.get(toRemove) == 0) available.remove(toRemove);
        if (available.size() == 0) res.add(curr);
        else {
            for (Character character : available.keySet()) {
                backtrack(res, new HashMap<>(available), new StringBuilder(curr).append(character), character);
            }
        }
    }
}
