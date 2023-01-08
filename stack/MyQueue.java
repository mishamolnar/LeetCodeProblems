package LeetCode.stack;

import java.util.Stack;

//https://leetcode.com/problems/implement-queue-using-stacks/
public class MyQueue {
    private Stack<Integer> entry;
    private Stack<Integer> queue;
    public MyQueue() {
        entry = new Stack<>();
        queue = new Stack<>();
    }

    public void push(int x) {
        entry.add(x);
    }

    public int pop() {
        if (queue.isEmpty()) formQueue();
        return queue.pop();
    }

    public int peek() {
        if (queue.isEmpty()) formQueue();
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty() && entry.isEmpty();
    }

    private void formQueue() {
        while (!entry.empty()) {
            queue.add(entry.pop());
        }
    }

}
