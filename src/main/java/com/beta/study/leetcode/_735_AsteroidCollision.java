package com.beta.study.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个整数数组 asteroids，表示在同一行的行星。
 * <p>
 * 对于数组中的每一个元素，其绝对值表示行星的大小，正负表示行星的移动方向（正表示向右移动，负表示向左移动）。每一颗行星以相同的速度移动。
 * <p>
 * 找出碰撞后剩下的所有行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：asteroids = [5,10,-5] 输出：[5,10] 解释：10 和 -5 碰撞后只剩下 10 。 5 和 10 永远不会发生碰撞。 示例 2：
 * <p>
 * 输入：asteroids = [8,-8] 输出：[] 解释：8 和 -8 碰撞后，两者都发生爆炸。 示例 3：
 * <p>
 * 输入：asteroids = [10,2,-5] 输出：[10] 解释：2 和 -5 发生碰撞后剩下 -5 。10 和 -5 发生碰撞后剩下 10 。
 *
 * @author shiqiu
 * @date 2022/04/17
 */
public class _735_AsteroidCollision {
    public static void main(String[] args) {
        //此题华为机试题遇到了
        int[] asteroids = {1, -2, -2, -2};
        int[] result = (new _735_AsteroidCollision()).asteroidCollision(asteroids);
        if (result != null) {
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i]);
                if (i < result.length - 1) {
                    System.out.print(",");
                }
            }
        }
        System.out.println();
        System.out.println("done");
    }

    private int[] asteroidCollision(int[] asteroids) {
        /**
         * * 初看此题，感觉不是很好下手，仔细想想，其实，两个行星能相撞，必然是：**一定是前一个往右，下一个往左！**  其他情况都不会撞；所以每次当前数据都是和前一个数作比较，那么就可以考虑用栈来解决了；
         * * 这里元素比较（行星质量比较，都是用绝对值比较，下面如果没明说，都是基于绝对值比较哈~）
         * * 下面依次分析：
         *     * 1、如果当前行星向右，那么不管三七二十一，直接入栈，因为不可能和当前栈的元素相撞；
         *     * 2、如果当前行星向左，那么就需要看栈顶元素的方向了：
         *         * 如果栈顶向左，不会撞，直接入栈
         *         * 如果栈顶向右，会相撞，先拿到栈顶元素，再去进行下一步操作：
         *             * 如果栈顶元素大于当前元素，那么当前被抵消，栈没有变化；直接进入下一轮行星质量获取；
         *             * 如果栈顶元素等于当前元素，那么两者都抵消，栈顶元素出栈；也不会有新的数据入栈，直接进入下一轮行星质量获取；
         *             * 如果栈顶元素小于当前元素，那么栈顶元素被抵消，栈顶元素出栈；那么当前元素应该入栈还是怎么操作？
         *                 * 仔细想想，可能会发现连续碰撞的情况，也就是拿当前向左的行星继续和栈顶元素比较，那么循环回到第二步，继续判断
         *                 * 这里还有需要注意，如果出栈后，栈空了，那么不用比较了，直接当前入栈；进入下一轮行星质量获取；
         *     * 3、经过一轮遍历后，栈内剩下的元素就是目标元素，组装结果即可（栈转换为数组）
         */
        if (asteroids == null || asteroids.length == 0) {
            throw new IllegalArgumentException("error");
        }
        //两个小球能碰撞，那么一定是前一个往右，下一个往左，所以可以用栈来模拟，因为每次比较对象都是前一个
        Deque<Integer> stack = new LinkedList<>();
        stack.push(asteroids[0]);
        for (int i = 1; i < asteroids.length; i++) {
            int currentNum = asteroids[i];
            //判断当前元素方向
            boolean currentLeft = currentNum < 0;
            //当前元素向左，需要额外操作
            if (currentLeft) {
                //这个循环就是为了处理，可能会连续碰撞的
                while (!stack.isEmpty()) {
                    //取栈顶元素
                    int prev = stack.peek();
                    //栈顶元素方向
                    boolean prevRight = prev > 0;
                    //栈顶元素向右，会发生碰撞
                    if (prevRight) {
                        //当前元素大于栈顶元素，那么栈顶元素被抵消，就是出栈操作
                        if (Math.abs(currentNum) > prev) {
                            stack.pop();
                            //出栈后，栈空了，当前元素入栈，无需再循环
                            if (stack.isEmpty()) {
                                stack.push(currentNum);
                                break;
                            }
                        }
                        //当前元素不大于栈顶元素，要么等于，要么小于；那么不会连续碰撞了，退出循环
                        else {
                            //当前元素等于栈顶元素，互相抵消，出栈
                            if (Math.abs(currentNum) == prev) {
                                stack.pop();
                            }
                            break;
                        }
                    }
                    //栈顶元素也向左，不会撞，当前元素入栈即可，退出循环
                    else {
                        stack.push(currentNum);
                        break;
                    }
                }
            }
            //当前元素向右，肯定和栈内元素不会撞，无需处理，直接入栈
            else {
                stack.push(currentNum);
            }
        }
        int[] result = new int[stack.size()];
        int i = stack.size() - 1;
        while (!stack.isEmpty()) {
            result[i--] = stack.pop();
        }
        return result;
    }
}
