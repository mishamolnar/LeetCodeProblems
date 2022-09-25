package LeetCode.myImpls;

import java.util.Arrays;

class MyCircularQueue {
    private int[] arr;
    private int head;
    private int tail;
    private int k;

    public MyCircularQueue(int k) {
        this.arr = new int[k];
        Arrays.fill(arr, -1);
        this.head = 0;
        this.tail = 0;
        this.k = k;
    }
    
    public boolean enQueue(int value) {
        if (arr[head] != -1)
            return false;
        arr[head] = value;
        head = (head + 1) % k;
        return true;
    }
    
    public boolean deQueue() {
        if (arr[tail] == -1)
            return false;
        arr[tail] = -1;
        tail = (tail + 1) % k;
        return true;
    }
    
    public int Front() {
        return arr[tail];
    }
    
    public int Rear() {
        return arr[head > 0 ? head - 1 : k - 1];
    }
    
    public boolean isEmpty() {
        return arr[head > 0 ? head - 1 : k - 1] == -1;
    }
    
    public boolean isFull() {
        return arr[head] != -1;
    }

    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        myCircularQueue.enQueue(1); // return True
        myCircularQueue.enQueue(2); // return True
        myCircularQueue.enQueue(3); // return True
        myCircularQueue.enQueue(4); // return False
        myCircularQueue.Rear();     // return 3
        myCircularQueue.isFull();   // return True
        myCircularQueue.deQueue();  // return True
        myCircularQueue.enQueue(4); // return True
        myCircularQueue.Rear();     // return 4
    }
}