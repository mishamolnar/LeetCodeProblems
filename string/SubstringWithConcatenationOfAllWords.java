package LeetCode.string;

import java.util.*;
import java.util.stream.Collectors;

public class SubstringWithConcatenationOfAllWords {






    public List<Integer> findSubstringTwo(String s, String[] words) {
        HashMap<String, Integer> dict = new HashMap<>();
        for (String word : words)
            dict.put(word, dict.getOrDefault(word, 0) +1);
        int len = words[0].length();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            res.addAll(findStart(s, dict, len, i, len * words.length));
        }
        return res;
    }

    private List<Integer> findStart(String s, HashMap<String, Integer> dict, int len, int start, int total) {
        HashMap<String, Integer> target = new HashMap<>(dict);
        List<Integer> res = new ArrayList<>();
        int left = start;
        for (int i = start; i <= s.length() - len; i += len) {
            if (i - left >= total) {
                String toAdd = s.substring(left, left + len);
                target.put(toAdd, target.get(toAdd) + 1);
                left += len;
            }

            String buff = s.substring(i, i + len);
            if (target.containsKey(buff)) {
                target.put(buff, target.get(buff) - 1);
                while (target.get(buff) < 0) {
                    String toAdd = s.substring(left, left + len);
                    target.put(toAdd, target.get(toAdd) + 1);
                    left += len;
                }
                if (i - left == total - len)
                    res.add(left);
            } else {
                target = new HashMap<>(dict);
                left = i + len;
            }
        }
        return res;
    }

    //good lienear time solution but it returns for
    //"aaaaaaaaaaaaaa"
    //["aa","aa"]
    //not [0,1,2,3,4,5,6,7,8,9,10]
    // but this - [0,2,4,6,8,10]x
    private Node root;

    public List<Integer> findSubstring(String s, String[] words) {
        root = new Node(false);
        Arrays.stream(words).forEach(this::addWord);
        Set<Integer> res = new HashSet<>();

        for (int i = 0; i < words[0].length(); i++) {
            int finalI = i;
            res.addAll(findSubstringHelper(s.substring(i), words)
                    .stream()
                    .map(num -> num + finalI)
                    .collect(Collectors.toList()));
        }
        return new ArrayList<>(res);
    }

    private Set<Integer> findSubstringHelper(String s, String[] words) {
        Set<Integer> res = new HashSet<>();
        HashMap<String,Integer> map = new HashMap<>();
        Queue<String> queue = new ArrayDeque<>();
        int start = 0, length = words[0].length(), size = 0;
        Node curr = root;

        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (curr.children[c] == null) {
                curr = root;
                start = i + 1;
                size = 0;
                map.clear();
                queue.clear();
            } else {
                curr = curr.children[c];
                if (curr.end) {
                    while (map.containsKey(curr.word) && map.get(curr.word) >= curr.count) {
                        String removed = queue.poll();
                        map.put(removed, map.get(removed) - 1);
                        size--;
                        start += length;
                    }
                    map.put(curr.word, map.getOrDefault(curr.word, 0) + 1);
                    queue.add(curr.word);
                    size++;
                    curr = root;
                    if (size == words.length) {
                        res.add(start);
                        size--;
                        map.put(queue.peek(), map.get(queue.poll()) - 1);
                        start += length;
                    }
                }
            }
        }
        return res;
    }


    private void addWord(String s) {
        Node buff = root;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';

            if (buff.children[c] == null)
                buff.children[c] = new Node(false);

            buff = buff.children[c];
        }
        buff.end = true;
        buff.word = s;
        buff.count++;
    }

    private static class Node {
        int count = 0;
        boolean end;
        String word;
        Node[] children;

        public Node(boolean end) {
            this.end = end;
            children = new Node[26];
        }
    }

    public static void main(String[] args) {
        SubstringWithConcatenationOfAllWords substringWithConcatenationOfAllWords = new SubstringWithConcatenationOfAllWords();
        System.out.println(substringWithConcatenationOfAllWords.findSubstringTwo("wordgoodgoodgoodbestword",
                new String[]{"word", "good", "best", "good"}));
    }

    //"wordgoodgoodgoodbestword"
    //["word","good","best","good"]
}
