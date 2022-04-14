package com.beta.study.huawei;

import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 描述
 * 数据表记录包含表索引index和数值value（int范围的正整数），请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照index值升序进行输出。
 *
 *
 * 提示:
 * 0 <= index <= 11111111
 * 1 <= value <= 100000
 *
 * 输入描述：
 * 先输入键值对的个数n（1 <= n <= 500）
 * 接下来n行每行输入成对的index和value值，以空格隔开
 *
 * 输出描述：
 * 输出合并后的键值对（多行）
 *
 * 示例1
 * 输入：
 * 4
 * 0 1
 * 0 2
 * 1 2
 * 3 4
 * 复制
 * 输出：
 * 0 3
 * 1 2
 * 3 4
 * @author shiqiu
 * @date 2022/04/10
 */
public class HJ8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n <= 0 || n > 500) {
            return;
        }
        Map<Integer, Integer> map = new TreeMap<>();
        int i=0;
        while (scanner.hasNext() && i++ < n) {
            String line = scanner.nextLine();
            String[] split = line.split(" ");
            if (split.length != 2) {
                continue;
            }
            int index = Integer.parseInt(split[0]);
            int value = Integer.parseInt(split[1]);
            if (index < 0 || index > 11111111) {
                continue;
            }
            if (value < 1 || value > 100000) {
                continue;
            }
            Integer integer = Optional.ofNullable(map.get(index)).map(v -> v + value).orElse(value);
            map.put(index, integer);
        }
        map.forEach((k, v) -> System.out.println(k + " " + v));
    }
}
