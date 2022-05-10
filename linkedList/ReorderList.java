package LeetCode.linkedList;

//link - https://leetcode.com/problems/reorder-list/
public class ReorderList {
    public static void main(String[] args) {
        ReorderList reorderList = new ReorderList();
        reorderList.reorderList(new ListNode(1, new ListNode(2)));
    }


    //O(n) time and constant space
    public void reorderList(ListNode head) {
        if (head.next == null) return;
        int size = 1;
        ListNode current = head;
        while (current.next != null) { //рахуємо розмір
            current = current.next;
            size++;
        }
        if (size == 2) return;
        int middle = (int) Math.ceil(size / 2.0);
        current = head;
        ListNode buff = head;
        while (middle != 0) { // знаходимо ноду посередині і розриваємо список
            current = current.next;
            middle--;
            if (middle == 1) continue;
            buff = buff.next;
        }
        buff.next = null; // розриваємо список
        current = reverseLinkedList(current, null); // обертаємо другу половину списку
        head = mergeLists(head, current); //з'єднуємо
    }

    private ListNode mergeLists(ListNode first, ListNode second) {
        if (first == null) return second;
        if (second == null) return first;
        first.next = mergeLists(second, first.next);
        return first;
    }

    private ListNode reverseLinkedList(ListNode head, ListNode newHead) {
        if (head == null) return newHead;
        ListNode next = head.next;
        head.next = newHead;
        return reverseLinkedList(next, head);
    }

    private static class ListNode {
        int val;
        ReorderList.ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ReorderList.ListNode next) { this.val = val; this.next = next; }
    }
}
