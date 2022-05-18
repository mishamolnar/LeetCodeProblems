package LeetCode.string;

import com.sun.source.tree.BreakTree;

import java.util.*;

//https://leetcode.com/problems/group-anagrams/
public class GroupAnagrams {

    // O(nmlogm) complexity - n is the total number of words and m is the length of each word
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }


    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        System.out.println(groupAnagrams.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }
}
