package LeetCode.backTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/next-closest-time/
public class NextClosestTime {
    public String nextClosestTime(String time) {
        time = time.replace(":", "");
        Set<Character> arr = new HashSet<>();
        for (int i = 0; i < 4; i++) arr.add((char) (time.charAt(i) - '0'));
        List<String> list = new ArrayList<>();
        backTrack(list, new StringBuilder(), arr);
        list.sort(String::compareTo);
        String ans = list.get((list.indexOf(time) + 1) % list.size());
        return ans.substring(0, 2) + ":" + ans.substring(2, 4);
    }

    private void backTrack(List<String> list, StringBuilder curr, Set<Character> arr) {
        if (curr.length() >= 4) {
            list.add(curr.toString());
        } else {
            for (int i : arr) {
                if ((curr.length() == 0 && i > 2)
                        || (curr.length() == 1 && curr.charAt(0) == '2' && i > 3)
                        || (curr.length() == 2 && i > 5)) continue;
                curr.append(i);
                backTrack(list, new StringBuilder(curr), arr);
                curr.deleteCharAt(curr.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        NextClosestTime nextClosestTime = new NextClosestTime();
        System.out.println(nextClosestTime.nextClosestTime("23:59"));
    }
}
