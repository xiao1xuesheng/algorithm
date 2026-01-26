package algorithm.linklist34;

import java.util.LinkedList;

// 返回两个无环链表相交的第一个节点
// 测试链接 : https://leetcode.cn/problems/intersection-of-two-linked-lists/
public class IntersectionOfTwoLinkedList {

    public static class LinkedNode {
        public int data;
        public LinkedNode next;
    }

    public LinkedNode getIntersectionNum(LinkedNode h1, LinkedNode h2) {
        int diff = 0;
        LinkedNode p1 = h1;
        LinkedNode p2 = h2;

        while (p1.next != null) {
            p1 = p1.next;
            diff++;
        }
        while (p2.next != null) {
            p2 = p2.next;
            diff--;
        }
        if (p1 != p2) {
            return null;
        }
        p1 = h1;
        p2 = h2;
        int absDiff = Math.abs(diff);
        while (absDiff > 0) {
            if (diff > 0) {
                p1 = p1.next;
            } else {
                p2 = p2.next;
            }
            absDiff--;
        }
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    // 双指针法 两个指针走过了相同的路径 必然会在相同或者同时为null时终止
    public LinkedNode getIntersectionNum1(LinkedNode headA, LinkedNode headB) {
        if (headA == null || headB == null) return null;
        LinkedNode pA = headA;
        LinkedNode pB = headB;
        while (pA != pB) {
            pA = pA==null ? headB : pA.next;
            pB = pB==null ? headA : pB.next;
        }
        return pA;
    }
}
