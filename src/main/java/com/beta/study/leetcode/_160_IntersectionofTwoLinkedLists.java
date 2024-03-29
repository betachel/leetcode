package com.beta.study.leetcode;

import com.beta.study.model.ListNode;

/**
 * @author shiqiu
 * @date 2022/05/02
 */
public class _160_IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int lena = 0, lenb = 0;
        ListNode temp = headA;
        while (temp != null) {
            lena++;
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            lenb++;
            temp = temp.next;
        }
        int sub = lena > lenb ? lena - lenb : lenb - lena;
        temp = lena > lenb ? headA : headB;
        //取两个链表最长的，其长度差为sub，较长的链表先走sub步
        while (sub-- > 0) {
            temp = temp.next;
        }
        ListNode head = lena > lenb ? headB : headA;
        //后续两个链表一次走，看是否相交
        while (head != null && temp != null) {
            if (head == temp) {
                return head;
            }
            head = head.next;
            temp = temp.next;
        }
        return null;

    }
}
