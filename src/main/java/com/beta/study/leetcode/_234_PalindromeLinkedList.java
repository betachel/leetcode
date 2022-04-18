package com.beta.study.leetcode;

import com.beta.study.model.ListNode;

/**
 * @author shiqiu
 * @date 2022/04/05
 */
public class _234_PalindromeLinkedList {
    public static void main(String[] args) {
        _234_PalindromeLinkedList instance = new _234_PalindromeLinkedList();
        ListNode head = ListNode.initNodes(new int[] {1, 2, 3, 4});
        ListNode newHead = instance.reverseList(head);
        System.out.println();
    }

    /**
     * 1、先对链表逆序，注意点：不能改变原链表，所以逆序的链表需要重新生成！
     * 2、依次对两个链表的元素进行比较，如果相等且能走到最后一个节点，那么是回文；如果中间某个节点值不等，直接return false；
     * 优化：只逆序后半部分，然后逆序后的后半部分与前半部分比较，todo
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }
        //先逆序，再判断
        ListNode newHead = this.reverseList(head);
        while (head != null && newHead != null) {
            if (head.val != newHead.val) {
                return false;
            }
            head = head.next;
            newHead = newHead.next;
        }

        return true;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = null, cur = head;
        while (cur != null) {
            ListNode node = new ListNode(cur.val);
            node.next = prev;
            prev = node;
            cur = cur.next;
        }
        return prev;
    }
}
