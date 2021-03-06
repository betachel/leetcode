package com.beta.study.leetcode;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 *
 * Example:
 *
 * Given this linked list: 1->2->3->4->5
 *
 * For k = 2, you should return: 2->1->4->3->5
 *
 * For k = 3, you should return: 3->2->1->4->5
 *
 * Note:
 *
 * Only constant extra memory is allowed.
 * You may not alter the values in the list's nodes, only nodes itself may be changed.
 *
 * @author shiqiu
 * @date 2019/06/26
 */
public class _25_ReverseNodesInKGroup {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode( int x ) {
            val = x;
        }
    }

    public static void main( String[] args ) {
        ListNode head = init( new int[] { 1 , 2 , 3 , 4 , 5 } );

        ListNode temp = reverseKGroup( head , 4 );
        while ( temp != null ) {
            System.out.print( temp.val + " -> " );
            temp = temp.next;
        }

        System.out.println( );
    }

    public static ListNode reverseKGroup( ListNode head , int k ) {

        ListNode result = null;

        if ( head == null || k <= 1 ) {
            return head;
        }

        ListNode current = head, next = null  , cTail = null ;

        int count = 0;
        while ( current != null ) {

            next = current.next;
            count = 0;
            while ( ++ count < k && next != null ) {
                next = next.next;
            }

            if ( count == k  ) {
                //reverse listnode
                count=0;
                ListNode next2 =  null , pre = null , c = current ;

                if ( cTail == null ) {
                    cTail = current ;
                }
                while ( ++count <= k  ) {
                    next2 = current.next;
                    current.next = pre;
                    pre = current;
                    current = next2;
                }

                if ( result == null ) {
                    result = pre;
                } else {
                    cTail.next = pre ;
                    cTail = c;
                }

            } else {
                if ( cTail != null ) {
                    cTail.next = current;
                }else {
                    result = head;
                }
                break;
            }
        }

        return result;
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
