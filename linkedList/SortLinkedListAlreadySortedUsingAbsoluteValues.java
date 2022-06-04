package LeetCode.linkedList;

import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode.com/problems/sort-linked-list-already-sorted-using-absolute-values/submissions/
public class SortLinkedListAlreadySortedUsingAbsoluteValues {

    //O(n) time and space
    public ListNode sortLinkedList(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode buff = head;
        Deque<Integer> stack = new ArrayDeque<>();
        while (buff != null && buff.next != null) {
            while (buff.next != null && buff.val > buff.next.val) {
                stack.push(buff.next.val);
                buff.next = buff.next.next;
            }
            buff = buff.next;
        }
        buff = dummy;
        while (buff.next != null && !stack.isEmpty()) {
            while (!stack.isEmpty() &&  buff.next.val > stack.peek()) {
                buff.next = new ListNode(stack.pop(), buff.next);
            }
            buff = buff.next;
        }
        return dummy.next;
    }


    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
