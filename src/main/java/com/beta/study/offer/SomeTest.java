package com.beta.study.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shiqiu
 * @date 2020/05/25
 */
public class SomeTest {
    public static void main(String[] args) {
        /*Map<Short , String> map = new HashMap<>();
        for ( short i = 0 ; i < 10;i++ ) {
            map.put(i , String.valueOf(i));
            map.remove(i + "1");
        }*/
        String s = "i use java ee not use golang";

        String[] arrays = s.split(" ");
        for (int i = 0, j = arrays.length - 1; i < arrays.length / 2; i++, j--) {
            String temp = arrays[i];
            arrays[i] = arrays[j];
            arrays[j] = temp;
        }
        String result = "";
        for (int i = 0; i < arrays.length; i++) {
            result += arrays[i];
            if (i < arrays.length-1) {
                result += " ";
            }
        }

        System.out.println(result);
    }
}
