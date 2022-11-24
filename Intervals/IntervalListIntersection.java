package LeetCode.Intervals;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersection {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int fir = 0, sec = 0;
        List<int[]> res = new ArrayList<>();
        while (fir < firstList.length && sec < secondList.length) {
            if (Math.max(firstList[fir][0], secondList[sec][0]) - Math.min(firstList[fir][1], secondList[sec][1]) >= 0) {
                res.add(new int[]{Math.max(firstList[fir][0], secondList[sec][0]), Math.min(firstList[fir][1], secondList[sec][1])});
            }
            if (firstList[fir][1] < secondList[sec][1])
                fir++;
            else sec++;
        }
        int[][] ans = new int[res.size()][];
        for (int i = 0; i < res.size(); i++)
            ans[i] = res.get(i);
        return ans;
    }
}
