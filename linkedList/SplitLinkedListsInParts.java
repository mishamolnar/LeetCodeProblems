package LeetCode.linkedList;

import java.util.List;

public class SplitLinkedListsInParts {
    public ListNode[] splitListToParts(ListNode head, int k) {
        //calculate length
        //big count = size % k, big size = size / k + 1
        //small count = k - big count, small size = size / k
        ListNode[] res = new ListNode[k];
        int size = calcSize(head);
        int bigCount = size % k, bigSize = size / k + 1;
        int smallCount = k - bigCount, smallSize = size / k;
        for (int i = 0; i < bigCount; i++) {
            ListNode[] curr = getPart(head, bigSize);
            res[i] = curr[0];
            head = curr[1];
        }
        for (int i = bigCount; i < k; i++) {
            ListNode[] curr = getPart(head, smallSize);
            res[i] = curr[0];
            head = curr[1];
        }
        return res;
    }

    private ListNode[] getPart(ListNode head, int length) {//0 - part, 1 - head
        if (head == null)
            return new ListNode[]{null, null};
        ListNode iterator = head;
        while (iterator.next != null && length > 1) {
            iterator = iterator.next;
            length--;
        }
        ListNode nextHead = iterator.next;
        iterator.next = null;
        return new ListNode[]{head, nextHead};
    }

    private int calcSize(ListNode head) {
        int res = 0;
        while (head != null) {
            head = head.next;
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(2, new ListNode(3, new ListNode(4)));
        new SplitLinkedListsInParts().calcSize(node);
        System.out.println(node.val);
    }



    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
