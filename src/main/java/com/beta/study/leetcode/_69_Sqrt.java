package com.beta.study.leetcode;

import java.util.IllformedLocaleException;

/**
 * @author shiqiu
 * @date 2022/05/04
 */
public class _69_Sqrt {
    public static void main(String[] args) {
        _69_Sqrt instance = new _69_Sqrt();
        int result = instance.mySqrt(4);
        System.out.println(result);
    }

    public int mySqrt(int x) {
        if (x < 0) {
            throw new IllegalArgumentException("error");
        }
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        int low = 1, high = x / 2;
        int mid = 0;
        //这里<=是关键
        while (low <= high) {
            mid = (high - low) / 2 + low;
            int sub = mid - x / mid;
            if (sub == 0) {
                //这里直接返回是关键
               return mid;
            }
            if (sub < 0) {
                //这里+1是关键
                low = mid + 1;
            } else {
                //这里-1是关键
                high = mid - 1;
            }
        }
        //这里-1是关键
        return low - 1;
    }

    /**
     * 带精度的sqrt
     * @param x
     * @param precision
     * @return
     */
    public double sqrt(double x, double precision) {
        if (x < 0) {
            throw new IllformedLocaleException("error");
        }
        if (x == 0D) {
            return 0D;
        }
        if (x == 1D) {
            return 1D;
        }
        double low = 1, high = x;
        //求中间数，这么写避免high+low溢出
        double mid = (high - low) / 2D + low;
        //求mid*mid与x的差值，为避免mid*mid溢出所以这么写
        double sub = mid - x / mid;
        //注意是sub的绝对值与精度无限靠近
        while (Math.abs(sub) > precision) {
            if (mid > x / mid) {
                high = mid;
            } else {
                low = mid;
            }
            mid = (high - low) / 2D + low;
            sub = mid - x / mid;
        }
        /**
         * //这里还有一种写法
         * while ((high-low) > precision) {
         *             if (mid > x / mid) {
         *                 high = mid;
         *             } else {
         *                 low = mid;
         *             }
         *             mid = (high - low) / 2D + low;
         *         }
         */
        return mid;
    }
}
