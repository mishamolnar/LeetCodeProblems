package LeetCode.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

class StockSpanner {
    Deque<int[]> stack;//0 index, 1 price
    int index;

    public StockSpanner() {
        stack = new ArrayDeque<>();
        stack.addFirst(new int[]{0, Integer.MAX_VALUE});
        index  = 0;
    }
    
    public int next(int price) {
        index++;
        while (!stack.isEmpty() && stack.peekFirst()[1] <= price) {
            stack.pollFirst();
        }
        int res = index - stack.peekFirst()[0];
        stack.addFirst(new int[]{index, price});
        return res;
    }
}