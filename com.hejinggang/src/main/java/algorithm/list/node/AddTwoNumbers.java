package algorithm.list.node;

import static algorithm.list.node.ListNode.generateListNode;
import static algorithm.list.node.ListNode.printList;

public class AddTwoNumbers {

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5};
        int [] arr2 = {2, 4, 6, 8};
        ListNode h1 = generateListNode(arr1);
        ListNode h2 = generateListNode(arr2);
        ListNode head1 = addTwoNumbers(h1, h2);
        printList(head1);
    }

    private static ListNode addTwoNumbers(ListNode h1, ListNode h2) {
        if (h1 == null || h2 == null) {
            return h1 == null ? h2 : h1;
        }
        int flag = 0;
        ListNode head = null;
        ListNode cur = null;
        while (h1 != null || h2 != null) {
            if (head == null) {
                cur = new ListNode(0);
                head = cur;
            } else {
                cur.next = new ListNode(0);
                cur = cur.next;
            }
            int value1 = h1 == null ? 0 : h1.val;
            int value2 = h2 == null ? 0 : h2.val;
            int sum = value1 + value2 + flag;
            flag = sum / 10;
            cur.val = sum % 10;
            h1 = h1 == null ? null : h1.next;
            h2 = h2 == null ? null : h2.next;
        }
        if (flag == 1) {
            cur.next = new ListNode(1);
        }
        return head;
    }
}
