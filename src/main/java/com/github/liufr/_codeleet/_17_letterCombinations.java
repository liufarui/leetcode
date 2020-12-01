package com.github.liufr._codeleet;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lfr
 * @date 2020/7/30 10:18
 * 
 * 17. 电话号码的字母组合
 * 
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 解题思路：
 * 递归。
 * 遍历第一个数字的所有字符，返回一个String列表；
 * 然后把这个列表和下一个数字作为参数传入，返回这个列表和数字所代表字符的所有组合值，返回依旧是一个String列表；
 * 直到最后一个字符。
 *
 * 最后，由于为了增加代码效率，所以使用StringBuild替代String。
 */
public class _17_letterCombinations {
    public List<String> letterCombinations(String digits) {
        /* 首先记录所有的字符 */
        char[][] letters = new char[10][4];
        letters[2] = new char[]{'a', 'b', 'c'};
        letters[3] = new char[]{'d', 'e', 'f'};
        letters[4] = new char[]{'g', 'h', 'i'};
        letters[5] = new char[]{'j', 'k', 'l'};
        letters[6] = new char[]{'m', 'n', 'o'};
        letters[7] = new char[]{'p', 'q', 'r', 's'};
        letters[8] = new char[]{'t', 'u', 'v'};
        letters[9] = new char[]{'w', 'x', 'y', 'z'};

        List<StringBuilder> list = new ArrayList<>();

        /* 从头遍历所有的字符 */
        for (char x : digits.toCharArray()) {
            /* 将此时的数字代表的字符列表和已经形成的字符串列表传入进去 */
            list = get(letters[x - '0'], list);
        }
        /* 将所有的StringBuild转换为String */
        List<String> ret_list = new ArrayList<>();
        for (StringBuilder sb : list) {
            ret_list.add(sb.toString());
        }
        return ret_list;
    }

    public List<StringBuilder> get(char[] x_list, List<StringBuilder> pre_list) {
        List<StringBuilder> list = new ArrayList<>();
        /* 如果列表为空，说明是第一个字符 */
        if (pre_list.size() == 0) {
            for (char x : x_list) {
                StringBuilder sb = new StringBuilder();
                list.add(sb.append(x));
            }
            return list;
        }

        /* 遍历所有的组合值 */
        for (StringBuilder pre : pre_list) {
            for (char x : x_list) {
                StringBuilder temp = new StringBuilder(pre);
                list.add(temp.append(x));
            }
        }
        return list;
    }
}
