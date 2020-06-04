package com.beta.study.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shiqiu
 * @date 2020/05/25
 */
public class SomeTest {
    public static void main(String[] args) {
        Map<Short , String> map = new HashMap<>();
        for ( short i = 0 ; i < 10;i++ ) {
            map.put(i , String.valueOf(i));
            map.remove(i + "1");
        }
    }
}
