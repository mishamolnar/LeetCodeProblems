package LeetCode.linkedList;

import java.util.List;

//https://leetcode.com/problems/sort-list/submissions/
public class SortList {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        tail.next = (list1 != null) ? list1 : list2;
        return dummyHead.next;
    }

    private  ListNode getMid(ListNode head) {
        ListNode midPrev = null;
        while (head != null && head.next != null) {
            midPrev = (midPrev == null) ? head : midPrev.next;
            head = head.next.next;
        }
        ListNode mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }

    //O(1) space not for interview
    public ListNode sortListTwo(ListNode head) {
        int size = 0, sortInterval = 1;
        ListNode buff = head;
        while (buff != null) {
            buff = buff.next;
            size++;
        }
        buff = head;
        while (sortInterval <= size) {
            ListNode one = null;
            ListNode two = null;
            ListNode newBuff = new ListNode(0);
            while (buff != null) {
                one = buff;
                for (int i = 0; buff != null && i < sortInterval; i++) buff = buff.next;
                cut(one, sortInterval);
                two = buff;
                for (int i = 0; buff != null && i < sortInterval; i++) buff = buff.next;
                cut(two, sortInterval);
                ListNode last = newBuff;
                while (last.next != null) last = last.next;
                last.next = sort(one, two);
            }
            buff = newBuff.next;
            sortInterval *= 2;
        }
        return buff;
    }

    private ListNode cut(ListNode node, int maxSize) {
        ListNode buff = new ListNode(0, node);
        for (int i = 0; buff != null && i < maxSize; i++) {
            buff = buff.next;
        }
        if (buff != null) buff.next = null;
        return node;
    }

    private ListNode sort(ListNode one, ListNode two) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (one != null || two != null) {
            if (two == null || (one != null && one.val < two.val)) {
                curr.next = one;
                one = one.next;
            } else {
                curr.next = two;
                two = two.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        SortList sortList = new SortList();
        sortList.sortList(new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3)))));
    }


    public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
}
