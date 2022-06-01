package LeetCode.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/line-reflection/submissions/
public class LineReflection {
    public boolean isReflected(int[][] points) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        HashSet<String> set = new HashSet<>();
        for(int[] p:points){
            max = Math.max(max,p[0]);
            min = Math.min(min,p[0]);
            String str = p[0] + "a" + p[1];
            set.add(str);
        }
        int y = max+min;
        for(int[] p:points){
            //int[] arr = {sum-p[0],p[1]};
            String str = (y-p[0]) + "a" + p[1];
            if( !set.contains(str))
                return false;

        }
        return true;
    }

    public static void main(String[] args) {
        LineReflection lineReflection = new LineReflection();
        System.out.println(lineReflection.isReflected(new int[][]{{0, 0}, {1, 0}}));
    }
}
