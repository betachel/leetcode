package com.beta.study.leetcode;

import com.beta.study.model.ListNode;
import com.beta.study.utils.ListNodeUtils;

/**
 * @author shiqiu
 * @date 2022/05/04
 */
public class _92_ReverseLinkedListII {
    public static void main(String[] args) {
        _92_ReverseLinkedListII instance = new _92_ReverseLinkedListII();
        ListNode head = ListNodeUtils.generateListNode(new int[] {1, 2, 3, 4, 5});
        head = instance.reverseBetween(head, 2, 5);
        ListNodeUtils.print(head);
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left >= right) {
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode leftprev = dummy, leftp = dummy.next;
        for (int i = 0; i < left - 1; i++) {
            if (leftp == null) {
                throw new IllegalArgumentException("error");
            }
            leftprev = leftprev.next;
            leftp = leftp.next;
        }
        //头插法逆序
        for (int i = 0; i < right - left; i++) {
            if (leftp == null || leftp.next == null) {
                throw new IllegalArgumentException("error");
            }
            ListNode next = leftp.next;
            leftp.next = leftp.next.next;
            next.next = leftprev.next;
            leftprev.next = next;
        }
        return dummy.next;
    }
}
