package com.beta.study.huawei.mianshi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 弹珠游戏 3 -5 6 -7 4 -4
 *
 * @author shiqiu
 * @date 2022/04/12
 */
public class Main1 {
    public static void main(String[] args) {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            String input = bf.readLine();
            if (input == null || input.length() == 0) {
                return;
            }
            String[] strs = input.split("\\s+");
            int[] nums = new int[strs.length];
            for (int i = 0; i < strs.length; i++) {
                nums[i] = Integer.parseInt(strs[i]);
            }
            Deque<Integer> stack = new ArrayDeque<Integer>(nums.length);
            stack.push(nums[0]);
            for (int i = 1; i < nums.length; i++) {
                if (stack.isEmpty()) {
                    stack.push(nums[i]);
                    continue;
                }
                boolean right = nums[i] > 0;
                int current = Math.abs(nums[i]);

                int top = stack.peek();
                boolean topLeft = top < 0;
                int temp = Math.abs(top);
                //栈顶往左，当前也入栈
                if (topLeft) {
                    stack.push(nums[i]);
                } else {
                    //栈顶往右
                    if (right) {
                        stack.push(nums[i]);
                    } else {
                        stack.pop();
                        if (current != temp) {
                            stack.push(current > temp ? nums[i] : top);
                        }
                    }
                }
            }
            int[] array = new int[stack.size()];
            int i = stack.size() - 1;
            while (!stack.isEmpty()) {
                array[i--] = stack.pop();
            }
            System.out.print("[");
            for (i = 0; i < array.length; i++) {
                System.out.print(array[i]);
                if (i<array.length-1) {
                    System.out.print(" ");
                }
            }
            System.out.print("]");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
