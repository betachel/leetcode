package com.beta.study.leetcode;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * @author shiqiu
 * @date 2019/06/02
 */
public class _2_AddTwoNumbers {
    public static void main( String[] args ) {
        ListNode l1 = initNodes( new int[]{2,4,3} );
        ListNode l2 = initNodes( new int[]{5,6,4} );

        ListNode result = addTwoNumbers( l1 , l2 );

        ListNode result2 = addTwoNumbers_2( l1 , l2 );

    }

    /**
     * 满足要求
     * 但是代码太长了
     * 改变了l1 l2的位置
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = null , listHead = null , temp = null ;

        int remainder = 0;
        while ( l1 != null && l2 != null ) {
            int sum = l1.val + l2.val + remainder;

            if ( listNode == null ) {
                listNode = new ListNode( sum % 10 );
                listHead = listNode;
            } else {
                temp = new ListNode( sum % 10 );
                listNode.next = temp;
                listNode = temp;
                listNode.next = null;
            }

            remainder = sum / 10 ;

            l1 = l1.next;
            l2 = l2.next ;
        }

        if ( l1 != null || l2 != null ) {
            ListNode temp2 = l1 != null ? l1 : l2;

            while ( temp2 != null ) {
                int sum = temp2.val + remainder;
                temp = new ListNode( sum % 10 );
                listNode.next = temp;
                listNode = temp;
                listNode.next = null;
                remainder = sum / 10;
                temp2 = temp2.next;
            }

        }

        if ( remainder > 0 ) {
            temp = new ListNode( remainder );
            listNode.next = temp;
            listNode = temp;
            listNode.next = null ;
        }

        return listHead;

    }

    public static ListNode addTwoNumbers_2(ListNode l1, ListNode l2) {
        ListNode listNode = null , listHead = null;
        ListNode listNode1 = l1 , listNode2 = l2 ;
        int remainder = 0;
        while ( listNode1 != null || listNode2 != null ) {
            int sum = remainder + ( listNode1 == null ? 0 : listNode1.val) +  ( listNode2 == null ? 0 : listNode2.val);

            if ( listNode == null ) {
                listNode = new ListNode( sum % 10 );
                listHead = listNode;
            } else {
                listNode.next = new ListNode( sum % 10 );
                listNode = listNode.next;
            }
            listNode.next = null;

            remainder = sum / 10;

            if ( listNode1 != null ) {
                listNode1 = listNode1.next;
            }
            if ( listNode2 != null ) {
                listNode2 = listNode2.next;
            }

        }
        if ( remainder > 0 ) {
            listNode.next = new ListNode( remainder );
            listNode = listNode.next;
            listNode.next = null;
        }
        return listHead;
    }

    public static ListNode initNodes(int [] nums ) {
        if ( nums.length < 1 ) {
            return null;
        }
        ListNode head ,  cur = new ListNode( nums[0] ) , temp;
        head = cur;

        for ( int i=1;i<nums.length;i++ ) {
            temp = new ListNode( nums[i] );
            cur.next = temp;
            cur = temp;
        }

        return head;

    }
}

class ListNode {
    int val ;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
    ListNode() {}
}
