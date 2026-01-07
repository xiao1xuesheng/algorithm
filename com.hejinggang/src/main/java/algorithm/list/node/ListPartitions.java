package algorithm.list.node;

import static algorithm.list.node.ListNode.generateListNode;
import static algorithm.list.node.ListNode.printList;

public class ListPartitions {

    public static void main(String[] args) {
        int []arr = {1,2,3,4,2,1,6};
        ListNode head = generateListNode(arr);

        ListNode head1 = partition(head, 3);

        printList(head1);
    }

    public static ListNode partition(ListNode head, int num) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode h1 = null, l1 = null;
        ListNode h2 = null, l2 = null;
        ListNode pre = head;
        while (pre != null) {
            if (pre.val < num) {
                if (h1 == null) {
                    h1 = pre;
                    l1 = pre;
                } else {
                    l1.next = pre;
                    l1 = l1.next;
                }
            } else {
                if (h2 == null) {
                    h2 = pre;
                    l2 = pre;
                } else {
                    l2.next = pre;
                    l2 = l2.next;
                }
            }
            pre = pre.next;
        }
        if (h1 == null) {
            return h2;
        }
        l1.next = h2;
        return h1;
    }
}
