package com.beta.study.huawei;

import java.util.Scanner;
import java.util.TreeMap;

/**
 * 描述 给定一些同学的信息（名字，成绩）序列，请你将他们的信息按照成绩从高到低或从低到高的排列,相同成绩
 * <p>
 * 都按先录入排列在前的规则处理。
 * <p>
 * 例示： jack      70 peter     96 Tom       70 smith     67
 * <p>
 * 从高到低  成绩 peter     96 jack      70 Tom       70 smith     67
 * <p>
 * 从低到高
 * <p>
 * smith     67
 * <p>
 * jack      70
 * <p>
 * Tom       70 peter     96
 * <p>
 * 注：0代表从高到低，1代表从低到高
 * <p>
 * 数据范围：人数：1\le n \le 200\1≤n≤200 进阶：时间复杂度：O(nlogn)\O(nlogn) ，空间复杂度：O(n)\O(n) 输入描述： 第一行输入要排序的人的个数n，第二行输入一个整数表示排序的方式，之后n行分别输入他们的名字和成绩，以一个空格隔开
 * <p>
 * 输出描述： 按照指定方式输出名字和成绩，名字和成绩之间以一个空格隔开
 * <p>
 * 示例1 输入： 3 0 fang 90 yang 50 ning 70 复制 输出： fang 90 ning 70 yang 50 复制 示例2 输入： 3 1 fang 90 yang 50 ning 70 复制 输出： yang 50 ning 70 fang 90
 *
 * @author shiqiu
 * @date 2022/04/10
 */
public class HJ68 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int type = scanner.nextInt();
        if (n <= 0 || (type != 0 && type != 1)) {
            return;
        }
        TreeMap<Integer, StringBuilder> map = new TreeMap<Integer, StringBuilder>((o1, o2) -> {
            if (o1 == null && o2 == null) {
                return 0;
            }
            if (o1 == null || o2 == null) {
                return 1;
            }
            return type == 0 ? o2 - o1 : o1 - o2;
        });
        while (n-- > 0) {
            String name = scanner.next();
            int score = scanner.nextInt();
            if (map.containsKey(score)) {
                map.get(score).append(name).append(" ");
            } else {
                map.put(score, new StringBuilder(name).append(" "));
            }
        }
        for (Integer key : map.keySet()) {
            StringBuilder sb = map.get(key);
            String[] names = sb.toString().split(" ");
            for (String name : names) {
                System.out.println(name + " " + key);
            }

        }
    }
}
