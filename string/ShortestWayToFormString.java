package LeetCode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/shortest-way-to-form-string/
public class ShortestWayToFormString {

    //O(n + m) time and O(n) space
    public int shortestWay(String source, String target) {
        int sLen = source.length(), sPointer = 0, res = 0;
        int[][] dict = new int[sLen][26];
        Arrays.fill(dict[sLen - 1], -1);
        for (int i = sLen - 1; i >= 0; i--) {
            if (i < sLen - 1) System.arraycopy(dict[i + 1], 0, dict[i], 0, 26);
            dict[i][source.charAt(i) - 'a'] = i + 1;
        }
        for (int i = 0; i < target.length(); i++) {
            if (dict[0][target.charAt(i) - 'a'] == -1) return -1; //взагалі такого немає в сорсі, повертаємо -1

            if (dict[sPointer][target.charAt(i) - 'a'] == - 1) { //немає на даній позиції, інкрементимо каунт и переносимось вперед
                res++;
                sPointer = 0;
            }

            sPointer = dict[sPointer][target.charAt(i) - 'a'];  //тепер ми точно знаємо що символ є після нашої позиції, переносимо поінтер

            if (sPointer == sLen) { //якщо поінтер в самому кінці то переносимось на початок і інкрементимо каунт
                res++;
                sPointer = 0;
            }
        }
        return res + (sPointer > 0 ? 1 : 0);
    }

    //O(nm) constant space
    public int shortestWayOne(String source, String target) {
        if (!hasSolution(source, target)) return -1;
        int res = 0, sourcePointer = 0;
        for (int i = 0; i < target.length(); i++) {
            while (source.charAt(sourcePointer) != target.charAt(i)) {
                sourcePointer++;
                if (sourcePointer >= source.length()) {
                    res++;
                    sourcePointer = 0;
                }
            }
            sourcePointer++;
            if (sourcePointer >= source.length()) {
                res++;
                sourcePointer = 0;
            }
        }
        return res + (sourcePointer > 0 ? 1 : 0);
    }


    private boolean hasSolution(String source, String target) {
        boolean[] arr = new boolean[26];
        for (int i = 0; i < source.length(); i++) arr[source.charAt(i) - 'a'] = true;
        for (int i = 0; i < target.length(); i++) {
            if (!arr[target.charAt(i) - 'a']) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ShortestWayToFormString shortestWayToFormString = new ShortestWayToFormString();
        System.out.println(shortestWayToFormString.shortestWay("adbsc", "addddddddddddsbc"));
    }
}
