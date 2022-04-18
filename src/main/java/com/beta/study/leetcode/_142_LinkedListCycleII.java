package com.beta.study.leetcode;

import com.beta.study.model.ListNode;

/**
 * @author shiqiu
 * @date 2022/04/05
 */
public class _142_LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        /**
         * 快慢指针，一个一次走一步，一个一次走两步，能相遇说明有环，否则无环
         * 看解释：https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/linked-list-cycle-ii-kuai-man-zhi-zhen-shuang-zhi-/
         */
        if (head == null) {return null;}
        ListNode slow = head, fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        fast = head;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
