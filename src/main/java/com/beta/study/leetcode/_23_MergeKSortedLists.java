package com.beta.study.leetcode;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * Example:
 *
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 *
 * @author shiqiu
 * @date 2019/06/25
 */
public class _23_MergeKSortedLists {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode( int x ) {
            val = x;
        }
    }

    public static void main( String[] args ) {
        ListNode[] lists = new ListNode[] { init( new int[] { 1 , 4 , 5 } ) , init( new int[] { 1 , 3 , 4 } ) , init( new int[] { 2 , 6 } ) };

        ListNode listNode = init( new int[]{0} );

        _23_MergeKSortedLists obj = new _23_MergeKSortedLists();

        ListNode head = obj.mergeKLists( lists );

        ListNode temp = head;
        while ( temp != null ) {
            System.out.print( temp.val + " -> " );
            temp = temp.next;
        }

        System.out.println( );
    }

    public ListNode mergeKLists( ListNode[] lists ) {

        if ( lists == null || lists.length == 0 ) {
            return null;
        }
        int length = lists.length;
        if ( length == 1 ) {
            return lists[ 0 ];
        }

        ListNode[] newLists = new ListNode[ length / 2 + 1 ];
        int count = 0;
        for ( int i = 0 ; i < length ; i = i+2 ) {
            ListNode list1 = lists[ i ];
            ListNode list2 = ( i + 1 ) < length ? lists[ i + 1 ] : null;

            ListNode sortedList = mergeTwoLists( list1 , list2 );

            if ( sortedList != null ) {
                newLists[ count++ ] = sortedList;
            }

        }
        if ( count <= 1 ) {
            return newLists[0];
        }

        return mergeKLists( newLists );
    }
    private ListNode mergeTwoLists( ListNode l1 , ListNode l2 ) {
        if ( l1 == null  ) {
            return l2;
        }
        if ( l2 == null ) {
            return l1;
        }
        ListNode head = null, tail = null, temp = null;
        ListNode list1 = l1, list2 = l2;

        while ( list1 != null && list2 != null ) {
            if ( list1.val <= list2.val ) {
                temp = list1;

                list1 = list1.next;
            } else {
                temp = list2;
                list2 = list2.next;
            }
            if ( head == null ) {
                head = temp;
                tail = head;
            } else {
                tail.next = temp;
                tail = tail.next;
            }
        }

        tail.next = list1 != null ? list1 : list2;

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
