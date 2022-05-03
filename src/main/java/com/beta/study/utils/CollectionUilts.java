package com.beta.study.utils;

import java.util.Collection;
import java.util.Iterator;

/**
 * @author shiqiu
 * @date 2022/05/03
 */
public class CollectionUilts {

    public static void print(Collection<?> collection) {
        if (collection == null || collection.size() == 0) {
            return;
        }
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
            if (iterator.hasNext()) {
                System.out.print(",");
            }
        }
    }
}
