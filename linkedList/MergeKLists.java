package LeetCode.linkedList;

import java.util.*;

public class MergeKLists {

    //complexity - O(n * log k), where k is length of lists and n number of all nodes
    public ListNode mergeKLists(ListNode[] lists) {
        ArrayList<ListNode> list = new ArrayList<>(Arrays.asList(lists));
        while (list.size() != 1) {
            ListNode first = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            ListNode second = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            list.add(mergeTwoLists(first, second));
        }
        return list.get(0);
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    // complexity O(n) where n number of all nodes
    public ListNode mergeKListsWithPQ(ListNode[] lists) {
        if (lists == null||lists.length == 0) return null;

        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1,ListNode o2){
                if (o1.val<o2.val)
                    return -1;
                else if (o1.val==o2.val)
                    return 0;
                else
                    return 1;
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;

        for (ListNode node: lists)
            if (node!=null)
                queue.add(node);

        while (!queue.isEmpty()){
            tail.next=queue.poll();
            tail=tail.next;

            if (tail.next!=null)
                queue.add(tail.next);
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
