package com.beta.study.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author betachel
 * @date 2022/05/22
 */
public class _232_ImplementQueueusingStacks {

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(myQueue.peek()); // return 1
        System.out.println(myQueue.pop()); // return 1, queue is [2]
        System.out.println(myQueue.empty()); // return false

    }

    private static class MyQueue {
        private Deque<Integer> stack1 = null;
        private Deque<Integer> stack2 = null;

        public MyQueue() {
            stack1 = new LinkedList<>();
            stack2 = new LinkedList<>();
        }

        public void push(int x) {
            if (stack1 == null) {
                return;
            }
            stack1.push(x);
        }

        public int pop() {
            if (stack1 == null || stack2 == null) {
                throw new IllegalArgumentException("error");
            }
            transfer();
            if (stack2.isEmpty()) {
                throw new IllegalArgumentException("queue is empty");
            }
            return stack2.pop();
        }

        public int peek() {
            if (stack1 == null || stack2 == null) {
                throw new IllegalArgumentException("error");
            }
            transfer();
            if (stack2.isEmpty()) {
                throw new IllegalArgumentException("queue is empty");
            }
            return stack2.peek();
        }

        public boolean empty() {
            return stack1 == null || stack2 == null || (stack1.isEmpty() && stack2.isEmpty());
        }

        private void transfer() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
        }
    }

}
