package algorithm.linklist34;

public class ReverseNodesInKGroup {

    public static class ListNode {
        public int val;
        public ListNode next;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <=1) {
            return head;
        }

        ListNode start = head;
        ListNode end = teamEnd(head, k);
        if (end == null) {
            return head;
        }
        head = end;
        reverse(start, end);
        ListNode lastEnd = start;
        while (lastEnd.next != null) {
            start = lastEnd.next;
            end = teamEnd(start, k);
            if (end != null) {
                return head;
            }
            reverse(start, end);
            lastEnd.next = end;
            lastEnd = start;
        }
        return head;
    }

    public static ListNode teamEnd(ListNode start, int k) {
        ListNode p = start;
        while (p != null & --k > 0) {
            p = p.next;
        }
        return p;
    }

    public static void reverse(ListNode s, ListNode e) {
        e = e.next;
        ListNode pre = null, cur = s, next = null;
        while (cur != e) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        s.next = e;
    }

//    public static ListNode reverseKGroup(ListNode head, int k) {
//        ListNode start = head;
//        ListNode end = teamEnd(head, k);
//        if (end == null) {
//            return head;
//        }
//        head = end;
//        reverse(start, end);
//        ListNode lastTeamEnd = start;
//        while (lastTeamEnd.next != null) {
//            start = lastTeamEnd.next;
//            end = teamEnd(start, k);
//            if (end == null) {
//                return head;
//            }
//            reverse(start, end);
//            lastTeamEnd.next = end;
//            lastTeamEnd = start;
//        }
//        return head;
//    }
//
//    public static ListNode teamEnd(ListNode h, int k) {
//        ListNode p = h;
//        while (--k > 0 && p != null) {
//            p = p.next;
//        }
//        return p;
//    }
//
//    public static void reverse(ListNode s, ListNode e) {
//        e = e.next;
//        ListNode pre = null, cur = s, next = null;
//        while (cur != e) {
//            next = cur.next;
//            cur.next = pre;
//            pre = cur;
//            cur = next;
//        }
//        s.next = e;
//    }
}
