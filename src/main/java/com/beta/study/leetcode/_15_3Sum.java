package com.beta.study.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 *
 * @author shiqiu
 * @date 2019/06/22
 */
public class _15_3Sum {
    public static void main( String[] args ) {
        int[] nums = new int[] { -1 , 0 , 1 , 2 , -1 , -4 };

        List < List < Integer > > result = threeSum( nums );

        if ( result != null && result.size( ) > 0 ) {
            result.stream( ).filter( it -> it != null && it.size( ) > 0 ).forEach( it -> it.stream( ).forEach( System.out :: println ) );
        }
    }

    public static List < List < Integer > > threeSum( int[] nums ) {
        List < List < Integer > > result = new LinkedList <>( );

        if ( nums != null && nums.length > 2 ) {
            Map < Integer, Integer > map = new HashMap <>( nums.length );
            int i = 0, length = nums.length;
            for ( int n : nums ) {
                map.put( n , i++ );
            }

            int sub = 0, temp = 0;
            Set < List < Integer > > set = new LinkedHashSet <>( );

            Set<Integer> set1 = new HashSet <>( length );

            for ( i = 0; i < length ; i++ ) {
                if ( ! set1.add( nums[ i ] ) ) {
                    continue;
                }
                sub = 0 - nums[ i ];
                Set<Integer> set2 = new HashSet <>( length );
                for ( int j = i + 1 ; j < length ; j++ ) {
                    if ( ! set2.add( nums[ j ] ) ) {
                        continue;
                    }
                    temp = sub - nums[ j ];
                    Integer index = map.get( temp );
                    if ( index != null && index != i && index != j ) {
                        List < Integer > list = Arrays.asList( nums[ i ] , nums[ j ] , temp );
                        list.sort( Integer :: compareTo );
                        if ( set.add( list ) ) {
                            result.add( list );
                        }
                    }
                }
            }

        }

        return result;
    }

}
