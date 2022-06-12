package LeetCode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/word-squares/solution/
public class WordSquares {
    int N = 0;
    String[] words = null;
    HashMap<String, List<String>> prefixHashTable = null;


    //time - O(n * 26 ^ L) L - length of inputs words, n - number of words
    //space - O(NL)
    public List<List<String>> wordSquares(String[] words) {
        this.N = words[0].length();
        this.words = words;

        List<List<String>> results = new ArrayList<List<String>>();
        buildPrefixHashTable(words);

        for (String word : words) {
            LinkedList<String> wordSquares = new LinkedList<String>();
            wordSquares.addLast(word);
            this.backtracking(1, wordSquares, results);
        }
        return results;
    }

    private void backtracking(int step, LinkedList<String> wordSquares, List<List<String>> results) {
        if (step == this.N) {
            results.add((List<String>) wordSquares.clone());
            return;
        }

        StringBuilder prefix = new StringBuilder();

        for (String wordSquare : wordSquares) {
            prefix.append(wordSquare.charAt(step));
        }

        for (String candidate : this.getWordsWithPrefix(prefix.toString())) {
            wordSquares.add(candidate);
            this.backtracking(step + 1, wordSquares, results);
            wordSquares.removeLast();
        }
    }

    private void buildPrefixHashTable(String[] words) {
        this.prefixHashTable = new HashMap<>();

        for (String word : words) {
            for (int i = 1; i < this.N; ++i) {
                String prefix = word.substring(0, i);
                List<String> wordList = this.prefixHashTable.get(prefix);
                if (wordList == null) {
                    wordList = new ArrayList<>();
                    wordList.add(word);
                    this.prefixHashTable.put(prefix, wordList);
                } else {
                    wordList.add(word);
                }
            }
        }
    }

    private List<String> getWordsWithPrefix(String prefix) {
        List<String> wordList = this.prefixHashTable.get(prefix);
        return wordList == null ? new ArrayList<>() : wordList;
    }
}
