package com.beta.study.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.beta.study.utils.CollectionUilts;

/**
 * @author shiqiu
 * @date 2022/05/03
 */
public class _54_SpiralMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        _54_SpiralMatrix instance = new _54_SpiralMatrix();
        List<Integer> result = instance.spiralOrder(matrix);
        CollectionUilts.print(result);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        if (null == matrix || matrix.length == 0 || matrix[0].length == 0) {
            throw new IllegalArgumentException("error");
        }
        int row = matrix.length, col = matrix[0].length;
        int size = row * col;
        int up = 0, down = row - 1, left = 0, right = col-1;

        List<Integer> result = new ArrayList<Integer>(size);
        while (result.size() < size) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[up][i]);
            }
            if(result.size() >= size ) {
                break;
            }
            up++;
            for (int i = up; i <= down; i++) {
                result.add(matrix[i][right]);
            }
            if(result.size() >= size ) {
                break;
            }
            right--;
            for (int i = right; i >= left; i--) {
                result.add(matrix[down][i]);
            }
            if(result.size() >= size ) {
                break;
            }
            down--;
            for (int i = down; i >= up; i--) {
                result.add(matrix[i][left]);
            }
            if(result.size() >= size ) {
                break;
            }
            left++;
        }
        return result;
    }
}
