package com.liufr.leetcode._codeleet;

/**
 * @author lfr
 * @date 2020/8/3 13:31
 *
 * 415. 字符串相加
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 *
 * 注意：
 * num1 和num2 的长度都小于 5100.
 * num1 和num2 都只包含数字 0-9.
 * num1 和num2 都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 *
 * 解题思路：
 * 方法很简单，就是从最后一位开始，两数相加。
 */
public class _415_addStrings {
    public static void main(String[] args) {
        addStrings("1", "9");
    }

    public static String addStrings(String num1, String num2) {
        char[] num1S = num1.toCharArray();
        char[] num2S = num2.toCharArray();
        /* 设置char数组接受最终的和 */
        char[] numS = new char[Math.max(num1S.length, num2S.length) + 1];

        int p1 = num1S.length - 1;
        int p2 = num2S.length - 1;
        /* 存储在数组里面的和是逆序的 */
        int p = 0;
        /* 设置进位标记 */
        int addFlag = 0;

        /* 首先从末尾遍历两个数组 */
        while (p1 >= 0 && p2 >= 0) {
            int sum = num1S[p1] + num2S[p2] - '0' * 2 + addFlag;
            addFlag = sum / 10;
            char x = (char) (sum % 10 + '0');
            numS[p++] = x;
            p1--;
            p2--;
        }
        /* 到这一步说明至少有一个数组已经遍历结束，继续遍历另外一个数组 */
        while (p1 >= 0) {
            int sum = num1S[p1] - '0' + addFlag;
            addFlag = sum / 10;
            char x = (char) (sum % 10 + '0');
            numS[p++] = x;
            p1--;
        }
        while (p2 >= 0) {
            int sum = num2S[p2] - '0' + addFlag;
            addFlag = sum / 10;
            char x = (char) (sum % 10 + '0');
            numS[p++] = x;
            p2--;
        }

        /* 最后别忘了最后的进位 */
        if (addFlag > 0) {
            numS[p] = '1';
        }

        StringBuilder sb = new StringBuilder();
        for (; p >= 0; p--) {
            /* 注意两个数都为0的情况 */
            if (numS[p] < '0') {
                continue;
            }
            sb.append(numS[p]);
        }

        return sb.toString();
    }
}
