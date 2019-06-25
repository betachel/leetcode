package com.beta.study.leetcode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 *
 *
 * Example:
 *
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * @author shiqiu
 * @date 2019/06/25
 */
public class _24_SwapNodesinPairs {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode( int x ) {
            val = x;
        }
    }

    public static void main( String[] args ) {
        ListNode head = init( new int[]{1,2,3} );

        ListNode temp = swapPairs( head );
        while ( temp != null ) {
            System.out.print( temp.val + " -> " );
            temp = temp.next;
        }

        System.out.println( );
    }

    public static ListNode swapPairs(ListNode head) {
        if ( head == null  ) {
            return null;
        }
        ListNode current = head , temp = null ;

        while ( current != null ) {
            if ( current.next != null ) {
                temp = current.next.next;
                int val = current.val;
                current.val = current.next.val;
                current.next.val = val;
            }else {
                break;
            }
            current = temp;
        }

        return head;
    }

    private static ListNode init( int[] array ) {
        if ( array == null || array.length == 0 ) {
            return null;
        }
        ListNode head = null, tail = null;

        for ( int v : array ) {
            ListNode temp = new ListNode( v );
            if ( head == null ) {
                head = temp;
                tail = head;
            } else {
                tail.next = temp;
                tail = temp;
            }
        }
        return head;
    }
}
