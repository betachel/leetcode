package com.beta.study.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shiqiu
 * @date 2022/03/31
 */
public class _118_PascalsTriangle {

    public static void main(String[] args) {
        int numRows = 1;
        _118_PascalsTriangle _118_PascalsTriangle = new _118_PascalsTriangle();
        List<List<Integer>> list = _118_PascalsTriangle.generate(numRows);
        list.stream()
            .forEach(it -> {
                for (int i : it) {
                    System.out.print(i);
                }
                System.out.println();
            });
    }

    public List<List<Integer>> generate(int numRows) {
        if (numRows <= 0) {
            throw new IllegalArgumentException("numRows must positive!");
        }
        List<List<Integer>> list = new ArrayList<>(numRows);
        List<Integer> sublist = new ArrayList<>(1);
        sublist.add(1);
        list.add(sublist);
        for (int i = 2; i <= numRows; i++) {
            List<Integer> temp = new ArrayList<>(i);
            list.add(temp);
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == (i - 1)) {
                    temp.add(1);
                } else {
                    temp.add(sublist.get(j) + sublist.get(j - 1));
                }
            }
            sublist = temp;

        }
        return list;
    }
}
