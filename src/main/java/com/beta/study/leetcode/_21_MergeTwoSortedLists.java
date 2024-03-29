package com.beta.study.leetcode;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->4, 1->3->4 Output: 1->1->2->3->4->4
 *
 * @author shiqiu
 * @date 2019/06/23
 */
public class _21_MergeTwoSortedLists {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public ListNode() {
        }
    }

    public static void main(String[] args) {
        /**
         * [-10,-9,-6,-4,1,9,9]
         * [-5,-3,0,7,8,8]
         */
        ListNode l1 = init(new int[] {-10, -9, -6, -4, 1, 9, 9});
        ListNode l2 = init(new int[] {-5, -3, 0, 7, 8, 8});

        ListNode head = mergeTwoLists(l1, l2);

        print(head);

        l1 = init(new int[] {-10, -9, -6, -4, 1, 9, 9});
        l2 = init(new int[] {-5, -3, 0, 7, 8, 8});

        head = mergeTwoLists_v2(l1, l2);

        print(head);

    }

    private static void print(ListNode head) {
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val);
            if (temp.next != null) {
                System.out.print(" -> ");
            }
            temp = temp.next;
        }
        System.out.println();

    }

    private static ListNode init(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        ListNode head = null, tail = null;

        for (int v : array) {
            ListNode temp = new ListNode(v);
            if (head == null) {
                head = temp;
                tail = head;
            } else {
                tail.next = temp;
                tail = temp;
            }
        }
        return head;
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = null, tail = null, temp = null;
        ListNode list1 = l1, list2 = l2;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                temp = list1;

                list1 = list1.next;
            } else {
                temp = list2;
                list2 = list2.next;
            }
            if (head == null) {
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

    public static ListNode mergeTwoLists_v2(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }
        ListNode head = null;
        ListNode cur = null, temp = null;

        while (list1 != null || list2 != null) {
            if (list1 == null) {
                cur.next = list2;
                break;
            } else if (list2 == null) {
                cur.next = list1;
                break;
            } else {
                if (list1.val <= list2.val) {
                    temp = list1;
                    list1 = list1.next;
                } else {
                    temp = list2;
                    list2 = list2.next;
                }
                if (head == null) {
                    cur = head = temp;
                } else {
                    cur.next = temp;
                    cur = temp;
                }
            }

        }

        return head;
    }

}
