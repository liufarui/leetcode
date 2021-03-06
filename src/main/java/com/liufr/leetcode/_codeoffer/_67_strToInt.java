package com.liufr.leetcode._codeoffer;

/**
 * @author lfr
 * @date 2020/7/15 17:17
 * 剑指 Offer 67. 把字符串转换成整数
 * 写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。
 */
public class _67_strToInt {
    public static int strToInt(String str) {
        if (str == null) {
            return 0;
        }
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        char[] chars = str.toCharArray();

        int i = 0;
        boolean positive = chars[0] != '-';
        if (chars[0] == '-' || chars[0] == '+') {
            i = 1;
        }

        long result = 0;
        for (; i < chars.length; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                if (result * 10 > Integer.MAX_VALUE || (result * 10 + chars[i] - '0') > Integer.MAX_VALUE) {
                    return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                } else {
                    result = result * 10 + (chars[i] - '0');
                }
            } else {
                break;
            }
        }

        return positive ? (int) result : (int) (-result);
    }

    public static void main(String[] args) {
        System.out.println(strToInt("42"));
    }
}
