package com.beta.study.practice;

import java.util.IllformedLocaleException;

/**
 * @author shiqiu
 * @date 2022/05/01
 */
public class MySqrt {

    public static void main(String[] args) {
        MySqrt instance = new MySqrt();
        double result = instance.sqrt(5, 0.0001);
        System.out.println(result);
    }

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
