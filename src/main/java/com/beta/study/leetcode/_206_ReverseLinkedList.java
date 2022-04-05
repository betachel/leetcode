package com.beta.study.leetcode;

import com.beta.study.leetcode.model.ListNode;

/**
 * @author shiqiu
 * @date 2022/04/05
 */
public class _206_ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = null , next = null , cur = head;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
