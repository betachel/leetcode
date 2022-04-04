package com.beta.study.leetcode;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 * <p>
 * Example:
 * <p>
 * Given linked list: 1->2->3->4->5, and n = 2.
 * <p>
 * After removing the second node from the end, the linked list becomes 1->2->3->5. Note:
 * <p>
 * Given n will always be valid.
 * <p>
 * Follow up:
 * <p>
 * Could you do this in one pass?
 *
 * @author shiqiu
 * @date 2019/06/22
 */
public class _19_RemoveNthNodeFromEndofList {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode head = init(5);

        ListNode result = removeNthFromEnd(head, 5);

       print(result);

        head = init(5);
        result = removeNthFromEnd_v2(head, 2);

        print(result);
    }

    private static void print(ListNode head) {
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val);
            if (temp.next != null) {
                System.out.print(" -> ");
            }
            temp = temp.next;
        }
        System.out.println();

    }

    public static ListNode init(int length) {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        int i = 1;
        while (i++ < length) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }

        return head;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode resultHead = null;
        ListNode temp = head;

        int length = 0;
        while (temp != null) {
            temp = temp.next;
            length++;
        }

        if (length > 0 && n <= length) {
            if (n == length) {
                resultHead = head.next;
            } else {
                int index = length - n, i = 1;
                resultHead = head;
                temp = head.next;
                ListNode pre = head;
                while (temp != null) {
                    if (i++ == index) {
                        pre.next = temp.next;
                        break;
                    } else {
                        pre = temp;
                        temp = temp.next;
                    }
                }
            }
        }

        return resultHead;
    }

    /**
     * 采用快慢指针
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd_v2(ListNode head, int n) {

        int count = 0;
        ListNode fast = head;
        while (count < n && fast != null) {
            fast = fast.next;
            count++;
        }
        if (fast == null) {
            return head.next;
        }
        ListNode slow = head;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;

        return head;
    }

}


