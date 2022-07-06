package LeetCode.stack;

import java.util.*;

//https://leetcode.com/problems/daily-temperatures/
public class DailyTemperatures {

    public static void main(String[] args) {
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        System.out.println(Arrays.toString(dailyTemperatures.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }

    //constant spoace
    public int[] dailyTemperaturesTwo(int[] temperatures) {
        int max = Integer.MIN_VALUE, len = temperatures.length;
        int[] res = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            if (temperatures[i] >= max) max = temperatures[i];
            else {
                int next = i + 1;
                while (temperatures[next] <= temperatures[i]) next += res[next];
                res[i] = next - i;
            }
        }
        return res;
    }

    //simple stack
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                temperatures[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) temperatures[stack.pop()] = 0;
        return temperatures;
    }

}
