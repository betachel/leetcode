package com.beta.study.huawei.mianshi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author shiqiu
 * @date 2022/04/12
 */
public class Main {
    public static void main(String[] args) {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            String str = bf.readLine();
            int n = Integer.parseInt(str);
            if (n == 0) {
                return;
            }
            str = bf.readLine();
            String[] strs = str.split("\\s+");
            if (strs.length == 0 || strs.length != n) {
                return;
            }
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(strs[i]);
            }
            int[] mins = new int[] {Integer.MAX_VALUE};

            if (isOrder(nums, mins)) {
                System.out.println(mins[0]);
            }
            //
            int length = nums.length;
            int min = nums[length - 1];
            int max = nums[0];
            int begin = 0, end = -1;
            for (int i = 0; i < length; i++) {
                if (nums[i] < max) {
                    end = i;
                } else {
                    max = nums[i];
                }
                if (nums[length - i - 1] > min) {
                    begin = length - i - 1;
                } else {
                    min = nums[length - i - 1];
                }
            }
            if (begin < end) {
                System.out.println(min);
            }
        } catch (IOException e) {

        }
    }

    private static boolean isOrder(int[] nums, int[] mins) {
        int i=0;
        for ( i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return false;
            }
            mins[0] = Math.min(mins[0], nums[i]);
        }
        if (i == nums.length - 1) {
            return true;
        }
        for ( i = nums.length - 1; i > 0; i--) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
            mins[0] = Math.min(mins[0], nums[i]);
        }
        return true;
    }
}
