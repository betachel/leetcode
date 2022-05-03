package com.beta.study.leetcode;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets. Open brackets must be closed in the correct order. Note that an empty string is also considered valid.
 * <p>
 * Example 1:
 * <p>
 * Input: "()" Output: true Example 2:
 * <p>
 * Input: "()[]{}" Output: true Example 3:
 * <p>
 * Input: "(]" Output: false Example 4:
 * <p>
 * Input: "([)]" Output: false Example 5:
 * <p>
 * Input: "{[]}" Output: true
 *
 * @author shiqiu
 * @date 2019/06/23
 */
public class _20_ValidParentheses {
    public static void main(String[] args) {
        String s = "{]}";

        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {

        boolean result = false;

        if (s == null || s.length() == 0 || s.trim().length() == 0) {
            result = true;
        } else {
            class MyNode {
                char c;
                MyNode next;
                MyNode prev;

                MyNode(char ch) {c = ch;}
            }

            String str = s.trim();
            int length = str.length();
            boolean isPush = true, isValidChar = true;
            MyNode head = null;
            MyNode tail = null;
            int count = 0;
            for (int i = 0; i < length && isValidChar; i++) {
                char ch = str.charAt(i);

                switch (ch) {
                    case '(':
                        ;
                    case '[':
                        ;
                    case '{':
                        isPush = true;
                        break;
                    case ')':
                        ;
                    case ']':
                        ;
                    case '}':
                        isPush = false;
                        break;
                    default:
                        isValidChar = false;
                }

                if (!isPush && tail != null) {
                    char tailCh = tail.c;

                    if ((ch == ')' && tailCh == '(') || (ch == '}' && tailCh == '{') || (ch == ']' && tailCh == '[')) {
                        tail = tail.prev;
                        tail.next = null;
                        count--;
                    } else {
                        isPush = true;
                    }
                }

                if (isPush || head == null) {
                    if (head == null) {
                        head = new MyNode(ch);
                        tail = head;
                        tail.prev = head;
                    } else {
                        tail.next = new MyNode(ch);
                        tail.next.prev = tail;
                        tail = tail.next;
                    }
                    count++;
                }
            }
            result = count == 0;
        }

        return result;
    }
}
