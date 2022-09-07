package LeetCode.stack;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//https://leetcode.com/problems/implement-stack-using-queues/solution/
class MyStack {
    Queue<Integer> one;

    public MyStack() {
        one = new ArrayDeque<>();
        Stack<Integer> stack = new Stack<>();
    }
    
    public void push(int x) {
        Queue<Integer> two = new ArrayDeque<>(one);
        one.removeAll(two);
        one.add(x);
        while (!two.isEmpty()) {
            one.add(two.poll());
        }
    }
    
    public int pop() {
        return one.poll();
    }
    
    public int top() {
        return one.peek();
    }
    
    public boolean empty() {
        return one.isEmpty();
    }
}