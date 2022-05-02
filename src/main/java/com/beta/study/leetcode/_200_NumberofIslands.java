package com.beta.study.leetcode;

/**
 * @author shiqiu
 * @date 2022/05/02
 */
public class _200_NumberofIslands {
    public int numIslands(char[][] grid) {
        if (null == grid || grid.length == 0 || grid[0].length == 0) {
            throw new IllegalArgumentException("error");
        }
        int maxRow = grid.length, maxCol = grid[0].length, count = 0;

        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxCol; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;

    }

    private void dfs(char[][] grid, int row, int col) {
        if (!isValid(row, col, grid)) {
            return;
        }
        //避免重复遍历
        if (grid[row][col] != '1') {
            return;
        }
        //标记当前已遍历
        grid[row][col] = '0';
        //dfs递归，往相邻位置扩散
        dfs(grid, row, col + 1);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row - 1, col);

    }

    private boolean isValid(int row, int col, char[][] grid) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
    }
}
