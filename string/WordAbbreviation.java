package LeetCode.string;

import java.util.*;

//https://leetcode.com/problems/word-abbreviation/
public class WordAbbreviation {
    public static void main(String[] args) {
        String[] arr = new String[]{"like","god","internal","me","internet","interval","intension","face","intrusion"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        //"l2e","god","internal","me","i6t","interval","inte4n","f2e","intr4n"
        WordAbbreviation wordAbbreviation = new WordAbbreviation();
        System.out.println(wordAbbreviation.abbreviation("internet", 1));
        System.out.println(wordAbbreviation.wordsAbbreviation(List.of(arr)));
    }


    //O(N2) time and linear space
    public List<String> wordsAbbreviation(List<String> words) {
        int N = words.size();
        int[] prefixes = new int[N];
        String[] abbr = new String[N];

        for (int i = 0; i < N; ++i)
            abbr[i] = abbreviation(words.get(i), 0);

        for (int i = 0; i < N; i++) {
            while (true) {
                Set<Integer> dupes = new HashSet<>();
                for (int j = i + 1; j < N; j++) {
                    if (abbr[i].equals(abbr[j]))
                        dupes.add(j);
                }

                if (dupes.isEmpty()) break;
                dupes.add(i);
                for (Integer dupe : dupes) {
                    abbr[dupe] = abbreviation(words.get(dupe), ++prefixes[dupe]);
                }
            }
        }

        return List.of(abbr);
    }

    private String abbreviation(String word, int i) {
        int N = word.length();
        if (N - i <= 3) return word;
        return word.substring(0, i+1) + (N - i - 2) + word.charAt(N-1);
    }




    //premium linear solution

    public List<String> wordsAbbreviationPrem(List<String> words) {
        Map<String, List<IndexedWord>> groups = new HashMap();
        String[] ans = new String[words.size()];

        int index = 0;
        for (String word: words) {
            String ab = abbrev(word, 0);
            if (!groups.containsKey(ab))
                groups.put(ab, new ArrayList());
            groups.get(ab).add(new IndexedWord(word, index));
            index++;
        }

        for (List<IndexedWord> group: groups.values()) {
            TrieNode trie = new TrieNode();
            for (IndexedWord iw: group) {
                TrieNode cur = trie;
                for (char letter: iw.word.substring(1).toCharArray()) {
                    if (cur.children[letter - 'a'] == null)
                        cur.children[letter - 'a'] = new TrieNode();
                    cur.count++;
                    cur = cur.children[letter - 'a'];
                }
            }

            for (IndexedWord iw: group) {
                TrieNode cur = trie;
                int i = 1;
                for (char letter: iw.word.substring(1).toCharArray()) {
                    if (cur.count == 1) break;
                    cur = cur.children[letter - 'a'];
                    i++;
                }
                ans[iw.index] = abbrev(iw.word, i-1);
            }
        }

        return Arrays.asList(ans);
    }

    public String abbrev(String word, int i) {
        int N = word.length();
        if (N - i <= 3) return word;
        return word.substring(0, i+1) + (N - i - 2) + word.charAt(N-1);
    }



    class TrieNode {
        TrieNode[] children;
        int count;

        TrieNode() {
            children = new TrieNode[26];
            count = 0;
        }
    }

    class IndexedWord {
        String word;
        int index;
        IndexedWord(String w, int i) {
            word = w;
            index = i;
        }
    }
}
