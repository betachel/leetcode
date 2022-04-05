package com.beta.study.leetcode.model;

/**
 * @author shiqiu
 * @date 2022/04/05
 */
public class ListNode {
    public int val ;
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
}
