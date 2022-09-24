package LeetCode.myImpls;

import java.util.Random;
import java.util.Stack;

class Skiplist {
    private Node head;
    private Random random;

    public Skiplist() {
        head = new Node(-1, null, null);
        random = new Random();
    }
    
    public boolean search(int target) {
        Node curr = head;
        while (curr != null) {
            while (curr.next != null && curr.next.val < target) {
                curr = curr.next;
            }
            if (curr.next != null && curr.next.val == target)
                return true;
            curr = curr.down;
        }
        return false;
    }
    
    public void add(int num) {
        Stack<Node> stack = new Stack<>();
        Node curr = head;
        while (curr != null) {
            while (curr.next != null && curr.next.val < num) {
                curr = curr.next;
            }
            stack.push(curr);
            curr = curr.down;
        }
        Node down = null;
        while (!stack.isEmpty()) {
            Node prev = stack.pop();
            prev.next = new Node(num, prev.next, down);
            down = prev.next;
            if (random.nextDouble() < 0.5)
                return;
        }
        head = new Node(-1, null, head);
    }
    
    public boolean erase(int num) {
        boolean found = false;
        Node curr = head;
        while (curr != null) {
            while (curr.next != null && curr.next.val < num) {
                curr = curr.next;
            }
            if (curr.next != null && curr.next.val == num) {
                curr.next = curr.next.next;
                found = true;
            }
            curr = curr.down;
        }
        return found;
    }
    
    private class Node {
        int val;
        Node next;
        Node down;
        
        Node(int val, Node next, Node down) {
            this.val = val;
            this.next = next;
            this.down = down;
        }
    }
}

/**
 * Your Skiplist object will be instantiated and called as such:
 * Skiplist obj = new Skiplist();
 * boolean param_1 = obj.search(target);
 * obj.add(num);
 * boolean param_3 = obj.erase(num);
 */