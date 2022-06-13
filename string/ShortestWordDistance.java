package LeetCode.string;

//https://leetcode.com/problems/shortest-word-distance/
public class ShortestWordDistance {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int one = 0, two = 100000, result = 100000;
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) one = i;
            if (wordsDict[i].equals(word2)) two = i;
            result = Math.min(result, Math.abs(two - one));
        }
        return result;
    }
}
