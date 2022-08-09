package LeetCode.linkedList;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/copy-list-with-random-pointer/
public class CopyListWithRandomPointer {

    //constant space
    public Node copyRandomList(Node head) {
        Node iter = head, next;

        // First round: make copy of each node,
        // and link them together side-by-side in a single list.
        while (iter != null) {
            next = iter.next;

            Node copy = new Node(iter.val);
            iter.next = copy;
            copy.next = next;

            iter = next;
        }

        // Second round: assign random pointers for the copy nodes.
        iter = head;
        while (iter != null) {
            if (iter.random != null) {
                iter.next.random = iter.random.next;
            }
            iter = iter.next.next;
        }

        // Third round: restore the original list, and extract the copy list.
        iter = head;
        Node pseudoHead = new Node(0);
        Node copy, copyIter = pseudoHead;

        while (iter != null) {
            next = iter.next.next;

            // extract the copy
            copy = iter.next;
            copyIter.next = copy;
            copyIter = copy;

            // restore the original list
            iter.next = next;

            iter = next;
        }

        return pseudoHead.next;
    }

    public Node copyRandomListLinearSpace(Node head) {
        List<Node> list = new ArrayList<>();
        int counter = 0;
        Node dummy = new Node(0);
        Node pointer = dummy;
        Node originalPointer = head;
        while (originalPointer != null) {
            pointer.next = new Node(originalPointer.val);
            pointer = pointer.next;
            list.add(pointer);
            originalPointer.val = counter;
            originalPointer = originalPointer.next;
            counter++;
        }

        originalPointer = head;
        pointer = dummy.next;
        while (originalPointer != null) {
            pointer.random = originalPointer.random != null ? list.get(originalPointer.random.val) : null;
            pointer = pointer.next;
            originalPointer = originalPointer.next;
        }

        return dummy.next;
    }


    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
