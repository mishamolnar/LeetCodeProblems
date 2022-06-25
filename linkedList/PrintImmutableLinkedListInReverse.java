package LeetCode.linkedList;

import java.util.Stack;

//https://leetcode.com/problems/print-immutable-linked-list-in-reverse/
public class PrintImmutableLinkedListInReverse {

    //linear time and sqrt(n)
    public void printLinkedListInReverse(ImmutableListNode head) {
        int size = size(head);
        int partSize = (int) Math.sqrt(size);

        Stack<ImmutableListNode> stack = formStack(head, partSize);
        while (!stack.isEmpty()) print(stack.pop(), partSize);
    }

    private void print(ImmutableListNode head, int size) {
        if (head == null || size == 0) return;
        print(head.getNext(), size - 1);
        head.printValue();
    }

    private Stack<ImmutableListNode> formStack(ImmutableListNode head, int size) {
        int counter = 0;
        Stack<ImmutableListNode> result = new Stack<>();

        while (head != null) {
            result.add(head);

            while (counter < size && head != null) {
                head = head.getNext();
                counter++;
            }
            counter = 0;
        }
        return result;
    }

    private int size(ImmutableListNode head) {
        int size = 0;
        while (head != null) {
            head = head.getNext();
            size++;
        }
        return size;
    }

    //linear time and space
    private void printLinkedListInReverseLinear(ImmutableListNode head) {
        if (head.getNext() != null) printLinkedListInReverse(head.getNext());
        head.printValue();
    }

    // This is the ImmutableListNode's API interface.
    // You should not implement it, or speculate about its implementation.
    interface ImmutableListNode {
        public void printValue(); // print the value of this node.
        public ImmutableListNode getNext(); // return the next node.
    };

}
