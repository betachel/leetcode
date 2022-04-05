package com.beta.study.leetcode;

import com.beta.study.leetcode.model.ListNode;

/**
 * @author shiqiu
 * @date 2022/04/05
 */
public class _141_LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        /**
         * 快慢指针，一个一次走一步，一个一次走两步，能相遇说明有环，否则无环
         */
        if (head == null) {return false;}
        ListNode slow = head, fast = head.next;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
