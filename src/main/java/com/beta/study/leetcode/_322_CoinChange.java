package com.beta.study.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.beta.study.utils.CollectionUilts;

/**
 * @author betachel
 * @date 2022/05/22
 */
public class _322_CoinChange {
    public static void main(String[] args) {
        _322_CoinChange instance = new _322_CoinChange();
        int[] coins = new int[] {411, 412, 413, 414, 415, 416, 417, 418, 419, 420, 421, 422};
        int amount = 9864;
        int result = instance.coinChange(coins, amount);
        System.out.println(result);
    }

    private Long count = Long.MAX_VALUE;
    private Long runTimes = 0L;

    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            throw new IllegalArgumentException("error");
        }
        Arrays.sort(coins);
        dfs(coins, 0, amount, 0, new LinkedList<>());
        return count == Long.MAX_VALUE ? -1 : count.intValue();
    }

    /**
     * dfs超时了，sad
     * 这个用例：
     * int[] coins = new int[] {411, 412, 413, 414, 415, 416, 417, 418, 419, 420, 421, 422};
     * int amount = 9864;
     * @param coins
     * @param prefixSum
     * @param amount
     * @param start
     * @param path
     */
    private void dfs(int[] coins, int prefixSum, int amount, int start, List<Integer> path) {
        if (start >= coins.length) {
            return;
        }
        if (prefixSum >= amount) {
            if (prefixSum == amount) {
                System.out.print(runTimes + " get it ===> ");
                CollectionUilts.print(path);
                System.out.println();
                count = Math.min(count, path.size());
            }
            return;
        }
        for (int i = start; i < coins.length; i++) {
            runTimes++;
            /**
             * 下面这个if对于提升性能很关键啊！！
             * 不加时间空间超过人数很少
             * 加完直接超过很多人！！！
             */
            if (prefixSum + coins[i] > amount) {
                return;
            }
            path.add(coins[i]);
            System.out.println("============");
            System.out.print(runTimes + " ===> before : ");
            CollectionUilts.print(path);
            System.out.println();
            dfs(coins, prefixSum + coins[i], amount, i, path);
            path.remove(path.size() - 1);
            System.out.print(runTimes + " ===> back : ");
            CollectionUilts.print(path);
            System.out.println();
        }
    }
}
