package LeetCode.linkedList;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;

//https://leetcode.com/problems/design-hit-counter/
public class HitCounter {
    private int total;
    private Deque<Node> deque;

    //O(n) space worst case if no getHits were called
    public HitCounter() {
        this.total = 0;
        this.deque = new ArrayDeque<>();
    }

    //O(1) complexity
    public void hit(int timestamp) {
        if (deque.isEmpty() || deque.getLast().timestamp < timestamp) {
            deque.add(new Node(timestamp, 1));
        } else {
            deque.getLast().size++;
        }
        total++;
    }

    //O(n) complexity worst case and O(1) average
    public int getHits(int timestamp) {
        while (!deque.isEmpty()) {
            int diff = timestamp - deque.getFirst().timestamp;
            if (diff < 300) break;
            else {
                Node removed = deque.removeFirst();
                total -= removed.size;
            }
        }
        return total;
    }

    private class Node{
        private int timestamp;
        private int size;

        public Node(int timestamp, int size) {
            this.timestamp = timestamp;
            this.size = size;
        }
    }

    public static void main(String[] args) {
        HitCounter hitCounter = new HitCounter();
        hitCounter.hit(1);       // hit at timestamp 1.
        hitCounter.hit(2);       // hit at timestamp 2.
        hitCounter.hit(3);       // hit at timestamp 3.
        hitCounter.getHits(4);   // get hits at timestamp 4, return 3.
        hitCounter.hit(300);     // hit at timestamp 300.
        hitCounter.getHits(300); // get hits at timestamp 300, return 4.
        hitCounter.getHits(301); // get hits at timestamp 301, return 3.
    }
}
