package LeetCode.linkedList;


// link - https://leetcode.com/problems/merge-two-sorted-lists/
public class MergeTwoSortedLists {

    //O(n) time and constant space
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode res = dummy;
        while (list1 != null || list2 != null) {
            if (list1 == null || (list2 != null && list1.val > list2.val)) {
                dummy.next = list2;
                list2 = list2.next;
            } else {
                dummy.next = list1;
                list1 = list1.next;
            }
            dummy = dummy.next;
        }
        return res.next;
    }

    public ListNode mergeTwoListsRec(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        if (list1.val > list2.val) {
            list1.next = mergeTwoListsRec(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoListsRec(list1, list2.next);
            return list2;
        }
    }

    private class ListNode {
        int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
