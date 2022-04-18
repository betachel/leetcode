package com.beta.study.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

import com.beta.study.model.ListNode;

/**
 * @author shiqiu
 * @date 2022/04/05
 */
public class _148_SortList {
    /**
     * 暴力解法，借助最小堆来实现，耗时和空间都比较大，不好，兜底解决
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 == null || o2 == null) {
                    return o1 == null ? -1 : 1;
                }
                return o1.compareTo(o2);
            }
        });
        while(head != null) {
            priorityQueue.add(head.val);
            head = head.next;
        }
        ListNode resultHead = new ListNode();
        ListNode pre = resultHead;
        while(!priorityQueue.isEmpty()) {
            pre.next = new ListNode(priorityQueue.poll());
            pre = pre.next;
        }
        return resultHead.next;
    }
}
