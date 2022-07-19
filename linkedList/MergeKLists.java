package LeetCode.linkedList;

import java.util.*;

public class MergeKLists {


    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        int actualSize = lists.length;
        while (actualSize > 1) {
            int newSize = 0, pointer = 0;
            while (pointer < actualSize) {
                if (pointer + 1 == actualSize) {
                    lists[newSize] = lists[pointer];
                    pointer++;
                    continue;
                }
                lists[newSize] = mergeTwoLists(lists[pointer], lists[pointer + 1]);
                newSize++;
                pointer += 2;
            }
            actualSize = newSize;
        }
        return lists[0];
    }

    private ListNode mergeTwoLists(ListNode one, ListNode two) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (one != null && two != null) {
            if (one.val < two.val) {
                curr.next = one;
                one = one.next;
            } else {
                curr.next = two;
                two = two.next;
            }
            curr = curr.next;
        }
        curr.next = one == null ? two : one;
        return dummy.next;
    }




    // n log k, where n - length of the list, k - number of lists
    public ListNode mergeKListsTwo(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode node : lists)
            if (node != null) pq.add(node);

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (!pq.isEmpty()) {
            curr.next = pq.poll();
            curr = curr.next;
            if (curr.next != null) pq.add(curr.next);
        }
        return dummy.next;
    }

    private class ListNode {
        int val;
        MergeKLists.ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, MergeKLists.ListNode next) { this.val = val; this.next = next; }
    }
}
