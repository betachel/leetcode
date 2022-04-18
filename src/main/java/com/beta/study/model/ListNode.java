package com.beta.study.model;

/**
 * @author shiqiu
 * @date 2022/04/05
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode() {}

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public static ListNode initNodes(int[] nums) {
        if (nums.length < 1) {
            return null;
        }
        ListNode head, cur = new ListNode(nums[0]), temp;
        head = cur;

        for (int i = 1; i < nums.length; i++) {
            temp = new ListNode(nums[i]);
            cur.next = temp;
            cur = temp;
        }

        return head;

    }
}
