package algorithm.list.node;

import static algorithm.list.node.ListNode.generateListNode;

public class MergeTwoLists {

    public static void main(String []args) {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 8, 10, 12};
        ListNode h1 = generateListNode(arr1);
        ListNode h2 = generateListNode(arr2);

        ListNode head = mergeTwoLists(h1, h2);
        ListNode.printList(head);
    }

    public static ListNode mergeTwoLists(ListNode h1, ListNode h2) {
        if (h1 == null || h2 == null) {
            return h1 == null ? h2 : h1;
        }

        ListNode head = h1.val <= h2.val ? h1 : h2;
        ListNode cur1 = h1.val <= h2.val ? h1.next : h1;
        ListNode cur2 = h1.val <= h2.val ? h2 : h2.next;

        ListNode pre = head;

        while (cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) {
                pre.next = cur1;
                pre = cur1;
                cur1 = cur1.next;
            } else {
                pre.next = cur2;
                pre = cur2;
                cur2 = cur2.next;
            }
        }

        pre.next = cur1 == null ? cur2 : cur1;

        return head;
    }
}
