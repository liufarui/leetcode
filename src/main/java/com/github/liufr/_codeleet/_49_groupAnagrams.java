package com.github.liufr._codeleet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author lfr
 * @date 2020/8/6 10:18
 * 
 * 49. 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 
 * 解题思路：
 * 以空间换取时间；
 * 首先我们设置一个叫interestSum的int型数组，保存字符串每个字符的乘积（这个乘积很少会被重复，但是有可能会重复，所以需要二次判断）
 *
 * 然后我们设计一个二维的char数组charss，保存strs（主要是基于之后会大量用到字符计算，这样会快一些）
 *
 * 创建一个hashmap，
 * 我们遍历这个字符串数组，如果interestSum的结果没有出现过，则在此map里面添加，并新建list添加到retList；
 * 如果interestSum结果出现过，则判断是否满足异位，满足则在原来的list中添加，不满足则新建list添加到retList；
 * 返回retList。
 *
 * 其实这个interestSum的设计，参考了HashMap的设计思想，还是挺有趣的。
 * 最后的时候，假设了每个字符只出现一次，虽然结果跑过了，但是不排除字符可以出现多次的情况，如果可以出现多次，在interestLike函数里面，
 * HashMap有可能会增加一个add操作；
 * 而且还有一点没有考虑到的就是，字符串非常长的时候，Integer越界的问题，如果字符串有可能很长，需要增加判断。
 */
public class _49_groupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> retList = new ArrayList<>();
        Integer[] interestSum = new Integer[strs.length];
        char[][] charss = new char[strs.length][];

        for (int i = 0; i < strs.length; i++) {
            charss[i] = strs[i].toCharArray();
            interestSum[i] = interestSum(charss[i]);
        }

        HashMap<Integer, List<String>> map = new HashMap<>();
        for (int i = 0; i < interestSum.length; i++) {
            if (map.containsKey(interestSum[i])) {
                if (interestLike(map.get(interestSum[i]), charss[i])) {
                    map.get(interestSum[i]).add(strs[i]);
                } else {
                    List<String> list = new ArrayList<>();
                    list.add(strs[i]);
                    retList.add(list);
                }
            } else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                retList.add(list);
                map.put(interestSum[i], list);
            }
        }
        return retList;
    }

    public Integer interestSum(char[] chars) {
        int ret = 1;
        for (char c : chars) {
            ret *= (c - 'a' + 1);
        }
        return ret;
    }

    public boolean interestLike(List<String> list, char[] chars) {
        char[] X = list.get(0).toCharArray();

        if (X.length != chars.length) {
            return false;
        }

        HashMap<Character, Integer> mapX = new HashMap<>();
        for (char c : X) {
            mapX.put(c, 1);
        }
        for (char c : chars) {
            if (!mapX.containsKey(c)) {
                return false;
            }
        }
        return true;
    }
}
