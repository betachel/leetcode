package com.beta.study.leetcode;

/**
 * @author shiqiu
 * @date 2019/06/26
 */
public class _26_RemoveDuplicatesFromSortedArray {
    public static void main( String[] args ) {
        int[] nums = new int[] { 0 , 0 , 1 , 1 , 1 , 2 , 2 , 3 , 3 , 4 };
        int count = removeDuplicates( nums );

        System.out.println( count );

    }

    public static int removeDuplicates( int[] nums ) {
        int count = 0;

        if ( nums == null || nums.length == 0 ) {
            return 0;
        }

        int currntNum = nums[ 0 ];
        int length = nums.length;
        count = 1;
        for ( int i = 1 ; i < length ; i++ ) {
            if ( currntNum != nums[ i ] ) {
                currntNum = nums[ i ];
                nums[count++] = currntNum;
            }
        }
        return count;
    }
}