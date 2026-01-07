package algorithm.list.node;

public class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static ListNode generateListNode(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        for (int value : arr) {
            current.next = new ListNode(value);
            current = current.next;
        }
        return dummyHead.next;
    }
}
