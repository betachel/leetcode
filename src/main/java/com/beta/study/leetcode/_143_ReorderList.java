package com.beta.study.leetcode;

import com.beta.study.model.ListNode;
import com.beta.study.utils.ListNodeUtils;

/**
 * @author shiqiu
 * @date 2022/05/03
 */
public class _143_ReorderList {
    public static void main(String[] args) {
        ListNode head = ListNodeUtils.generateListNode(new int[] {1, 2, 3, 4, 5});
        _143_ReorderList instance = new _143_ReorderList();
        instance.reorderList(head);
        ListNodeUtils.print(head);
    }

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        /**
         * 1、快慢指针找到中间节点
         * 2、翻转后半段
         * 3、前后半段合并
         */
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //找到中间节点
        ListNode needReverseHead = slow.next;
        slow.next = null;
        //翻转后半段
        ListNode reverseHead = reverse(needReverseHead);
        //合并前后半段
        slow = head;
        while (slow != null && reverseHead != null) {
            ListNode next = slow.next;
            ListNode reverseNext = reverseHead.next;
            slow.next = reverseHead;
            reverseHead.next = next;

            slow = next;
            reverseHead = reverseNext;

        }

    }

    /**
     * 逆序链表，新生成一个链表，头插法
     */
    private ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode temp = head;
        ListNode prev = null;
        while (temp != null) {
            ListNode next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;

    }

}
