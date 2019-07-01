package com.beta.study.leetcode;

/**
 * Implement strStr().
 *
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Example 1:
 *
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 *
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * Clarification:
 *
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 *
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 *
 * @author shiqiu
 * @date 2019/07/01
 */
public class _28_ImplementstrStr {
    public static void main( String[] args ) {
        System.out.println(strStr( "mississippi" , "issipi" ));
    }

    public static int strStr( String haystack , String needle ) {

        if ( haystack == null ) {
            return - 1;
        }
        if ( needle == null || needle.length( ) == 0 ) {
            return 0;
        }
        int length = haystack.length( );
        int length2 = needle.length( );

        if ( length < length2 ) {
            return -1;
        }

        boolean flag = false;
        for ( int i = 0 ; i < length ; i++ ) {
            flag=false;
            if ( haystack.charAt( i ) == needle.charAt( 0 ) ) {
                int j = 1 ;
                for (  ; j < length2 && (i+j)  < length ; j++ ) {
                    if ( haystack.charAt(i+j ) != needle.charAt( j ))  {
                        flag = true;
                        break;
                    }
                }
                if ( ! flag && j ==  length2) {
                    return i;
                }
            }

        }

        return -1;
    }
}