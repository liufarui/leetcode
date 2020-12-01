package com.github.liufr._codeleet;

/**
 * @author lfr
 * @date 2020/7/22 15:23
 *
 * 5. 最长回文子串
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。
 * 你可以假设 s 的最大长度为 1000。
 *
 * 解题思路：
 * 先将原先的字符串做预处理，开头结尾以及每两个字符串中间增加一个'#'；
 * 这样做的原因是因为回文不光有'aba'这种模式，还有'abba'这种模式；
 * 然后枚举所有的字符；
 * 将其从自身向左右扩散，如果左右字符相同，则继续扩散，如果不同，则跳出。
 *
 * 最后的时候，增加一个判断，如果从i开始剩余长度比现已经发现的最大长度要小的时候，则退出。
 * 原因在于，就算剩余的字符全部和左边互文，也不能产生更长的满足条件的字符串了。
 *
 * 再最后的最后，又做了一点小小的优化，针对于上句说的，我们再枚举所有字符的时候，可以使用两个循环，
 * 从字符串最中心点开始，这样的话不光可以节约遍历到右边末尾的时间，也可以节约遍历到左边末尾的时间。
 * 应该还可以继续优化，本次先这样。
 */
public class _5_longestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }

    public static String longestPalindrome(String s) {
        // 预处理，插入一个特殊字符
        char[] chars = pre(s);

        // 记录最大长度和最长字符串
        int maxLength = 0;
        String maxStr = "";

        for (int i = chars.length / 2; i < chars.length; i++) {
            int start = i - 1;
            int end = i + 1;

            while (start >= 0 && end < chars.length && chars[start] == chars[end]) {
                // 字符向左向右平移
                start--;
                end++;
            }
            // 最后的时候还要经过一次回退，因为现在的start和end是不满足条件的。
            start++;
            end--;

            // 记录
            if (maxLength < end - start + 1) {
                maxLength = end - start + 1;
                maxStr = s.substring(start / 2, end / 2);
            }

            if (maxLength / 2 > chars.length - i - 1) {
                break;
            }
        }

        for (int i = chars.length / 2 - 1; i >= 0; i--) {
            int start = i - 1;
            int end = i + 1;

            while (start >= 0 && end < chars.length && chars[start] == chars[end]) {
                // 字符向左向右平移
                start--;
                end++;
            }
            // 最后的时候还要经过一次回退，因为现在的start和end是不满足条件的。
            start++;
            end--;

            // 记录
            if (maxLength < end - start + 1) {
                maxLength = end - start + 1;
                maxStr = s.substring(start / 2, end / 2);
            }

            if (maxLength / 2 > i - 1) {
                break;
            }
        }

        return maxStr;
    }

    private static char[] pre(String s) {
        char[] o_chars = s.toCharArray();

        int length = o_chars.length * 2 + 1;
        char[] n_chars = new char[length];


        for (int i = 0; i < o_chars.length; i++) {
            n_chars[i * 2] = '#';
            n_chars[i * 2 + 1] = o_chars[i];
        }
        n_chars[length - 1] = '#';

        return n_chars;
    }
}
