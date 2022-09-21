package LeetCode.linkedList;

public class ReverseNodesinEvenLengthGroups {
    public ListNode reverseEvenLengthGroups(ListNode head) {

        int curr = 1;
        ListNode res = new ListNode(0);
        ListNode pointer = res;
        while (head != null) {
            ListNode dummy = head;
            ListNode reverse = dummy;
            int i = 1;
            for (; i < curr; i++) {
                if (dummy.next == null) break;
                dummy = dummy.next;
            }
            head = dummy.next;
            dummy.next = null;
            pointer.next = (i % 2 == 0) ? reverseList(reverse) : reverse;
            while (pointer.next != null)
                pointer = pointer.next;
            curr++;
        }
        return res.next;
    }


    private ListNode reverseList(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode buff = head;
            head = head.next;

            buff.next = prev;
            prev = buff;
        }
        return prev;
    }

    public static void main(String[] args) {
        //5,2,6,3,9,1,7,3,8,4
        ReverseNodesinEvenLengthGroups reverse = new ReverseNodesinEvenLengthGroups();
        System.out.println(reverse.reverseEvenLengthGroups(new ListNode(5, new ListNode(6, new ListNode(2,
                new ListNode(
                        3, new ListNode(9, new ListNode(1, new ListNode(7, new ListNode(3, new ListNode(8, new ListNode(4))))))
                ))))));
    }
    
    
      private static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
