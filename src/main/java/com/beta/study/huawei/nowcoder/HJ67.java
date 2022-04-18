package com.beta.study.huawei.nowcoder;

import java.util.Scanner;

/**
 * 描述 给出4个1-10的数字，通过加减乘除运算，得到数字为24就算胜利,除法指实数除法运算,运算符仅允许出现在两个数字之间,本题对数字选取顺序无要求，但每个数字仅允许使用一次，且需考虑括号运算 此题允许数字重复，如3 3 4 4为合法输入，此输入一共有两个3，但是每个数字只允许使用一次，则运算过程中两个3都被选取并进行对应的计算操作。 输入描述： 读入4个[1,10]的整数，数字允许重复，测试用例保证无异常数字。
 * <p>
 * 输出描述： 对于每组案例，输出一行表示能否得到24点，能输出true，不能输出false
 * <p>
 * 示例1 输入： 7 2 1 10 复制 输出： true
 *
 * @author shiqiu
 * @date 2022/04/10
 */
public class HJ67 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        if (string == null || string.length() == 0) {
            return;
        }
        String[] strings = string.split(" ");
        if (strings == null || strings.length != 4) {
            return;
        }
        int[] nums = new int[4];
        for (int i = 0; i < 4; i++) {
            nums[i] = Integer.parseInt(strings[i]);
        }
        new HJ67().check(nums, 0, 0, false);
    }

    private void check(int[] nums, int i, int target, Boolean flag) {
        if (i == nums.length || flag) {
            if (target == 24 || flag) {
                flag = true;
                System.out.println(true);
            }
            return;
        }
        //for (int j = 0; j < nums.length; j++) {
        //    if (i == j) {
        //        continue;
        //    }
        check(nums, i + 1, target + nums[i], flag);
        check(nums, i + 1, target - nums[i], flag);
        check(nums, i + 1, target * nums[i], flag);
        if (target % nums[i] == 0) {
            check(nums, i + 1, target / nums[i], flag);
        }
        //}
    }
}
