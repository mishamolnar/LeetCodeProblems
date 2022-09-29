package LeetCode.linkedList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class RemoveZeroSumConsecutiveLinkedList {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0), cur = dummy;
        dummy.next = head;
        int prefix = 0;
        Map<Integer, ListNode> m = new HashMap<>();
        while (cur != null) {
            prefix += cur.val;
            if (m.containsKey(prefix)) {
                cur =  m.get(prefix).next;
                int p = prefix + cur.val;
                while (p != prefix) {
                    m.remove(p);
                    cur = cur.next;
                    p += cur.val;
                }
                m.get(prefix).next = cur.next;
            } else {
                m.put(prefix, cur);
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    

    public static void main(String[] args) {
        //1,3,2,-3,-2,5,5,-5,1
        RemoveZeroSumConsecutiveLinkedList removeZeroSumConsecutiveLinkedList = new RemoveZeroSumConsecutiveLinkedList();
        System.out.println(removeZeroSumConsecutiveLinkedList.removeZeroSumSublists(
                new ListNode(1, new ListNode(3, new ListNode(2, new ListNode(-3, new ListNode(-2,
                        new ListNode(5, new ListNode(5, new ListNode(-5, new ListNode(1)))))))))
        ));
    }


      private static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

}
