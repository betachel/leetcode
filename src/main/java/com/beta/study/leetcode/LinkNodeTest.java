package com.beta.study.leetcode;

/**
 * @author shiqiu
 * @date 2019/06/26
 */
public class LinkNodeTest {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public ListNode() {}
    }

    private static ListNode init(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        ListNode head = null, tail = null;

        for (int v : array) {
            ListNode temp = new ListNode(v);
            if (head == null) {
                head = temp;
                tail = head;
            } else {
                tail.next = temp;
                tail = temp;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = init(new int[] {1, 2, 3, 4, 5});

        //print(reverse(head));

        print(reverse_v2(head));
    }

    private static void print(ListNode head) {
        ListNode head_ = head;
        while (head_ != null) {
            System.out.print(head_.val);
            if (head_.next != null) {
                System.out.print(" -> ");
            }
            head_ = head_.next;
        }
    }

    public static ListNode reverse(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pre = null, next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;

        }
        return pre;
    }

    public static ListNode reverse_v2(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        //头插法逆序
        ListNode next = null;
        while (head.next != null) {
            next = head.next;
            head.next = head.next.next;
            next.next = dummy.next;
            dummy.next = next;

        }
        return dummy.next;
    }
}
