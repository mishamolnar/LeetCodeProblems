package LeetCode.heap;


//https://leetcode.com/problems/lru-cache/submissions/
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class LRUCache {
    HashMap<Integer, Node> map = new HashMap<>();
    int capacity;
    int count;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node curr;
        if (map.containsKey(key)) curr = map.get(key);
        else return -1;
        remove(curr);
        addToHead(curr.key, curr.val);
        return curr.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node old = map.get(key);
            remove(old);
            addToHead(key, value);
            map.put(key, head.next);
        } else {
            addToHead(key, value);
            map.put(key, head.next);
            if (count == capacity) {
                map.remove(tail.prev.key);
                remove(tail.prev);
            }
            else count++;
        }
    }

    private Node remove(Node node) {
        Node nextNode = node.next;
        Node prevNode = node.prev;
        nextNode.prev = prevNode;
        prevNode.next = nextNode;
        return node;
    }

    private void addToHead(int key, int val) {
        Node curr = new Node(key, val);
        Node prevFirst = head.next;
        curr.next = prevFirst;
        prevFirst.prev = curr;
        head.next = curr;
        curr.prev = head;
    }

    private class Node {
        private int key;
        private int val;
        private Node next;
        private Node prev;

        public Node() {
        }

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(1, 10); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println(lRUCache.get(1));    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // return -1 (not found)
        System.out.println(lRUCache.get(3));    // return 3
        System.out.println(lRUCache.get(4));    // return 4

    }


}
