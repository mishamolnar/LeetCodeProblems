package LeetCode.linkedList;

//https://leetcode.com/problems/partition-list/submissions/
public class PartitionList {

    public static void main(String[] args) {
        PartitionList partitionList = new PartitionList();
        System.out.println(partitionList.partition(new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2,new ListNode(5, new ListNode(2)))))),3));
    }


    public ListNode partitionIterative(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0), dummy2 = new ListNode(0);  //dummy heads of the 1st and 2nd queues
        ListNode curr1 = dummy1, curr2 = dummy2;      //current tails of the two queues;
        while (head!=null){
            if (head.val<x) {
                curr1.next = head;
                curr1 = head;
            }else {
                curr2.next = head;
                curr2 = head;
            }
            head = head.next;
        }
        curr2.next = null;          //important! avoid cycle in linked list. otherwise u will get TLE.
        curr1.next = dummy2.next;
        return dummy1.next;
    }

    //O(n) time and constant space
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode firstHead = removeAllNodes(head, Integer.MIN_VALUE, x - 1);
        ListNode secondHead = removeAllNodes(head, x, Integer.MAX_VALUE);
        ListNode pointer = firstHead;
        if (pointer == null) return secondHead;
        while (pointer.next != null) pointer = pointer.next;
        pointer.next = secondHead;
        return firstHead;
    }

    private ListNode removeAllNodes(ListNode head, int low, int hi) {
        if (head == null) return null;
        ListNode newHead = new ListNode(head.val);
        newHead.next = removeAllNodes(head.next, low, hi);
        return newHead.val >= low && newHead.val <= hi ? newHead : newHead.next;
    }


    private static class ListNode {
        int val;
        PartitionList.ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, PartitionList.ListNode next) { this.val = val; this.next = next; }
    }
}
