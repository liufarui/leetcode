package com.liufr.leetcode._codeleet;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lfr
 * @date 2020/7/30 12:10
 * 
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 
 * 解题思路：
 * 其实很多时候，没有必要把问题想的太过复杂，有很多题其实本身就只有一道朴素解法可解，
 * 并不一定都有很简单的高级解法。
 * 
 * 本题时间复杂度本身就很高，可以考虑到的比较好一点的解法就是缓存，以及dp。
 * 首先，我们在代码中添加一个缓存，记录不同的n值的结果，因为每一次计算都需要从0计算到n，下一次的时候n小的时候，就可以直接取出来了。
 * 
 * 其次，我们我们计算的时候，我们可以看作是：
 * (左边) + 右边
 * 这种格式，左边有可能为空，右边也有可能为空，所以我们需要遍历所有的左边和右边的情况：
 * 最初的情况当然是左边有0对，右边有n-1对，
 * 最后的情况是左边有n-1对，右边有0对。
 * 
 * 最后呢，我们通过StringBuilder的方式，去优化一下字符串拼接的效率。
 * 
 * 所以当左边有i对的时候，右边有[n-i-1]对，这个时候，左边的情况可以通过cache[i]去获取到，右边同理。
 * 具体流程如下
 */
public class _22_generateParenthesis {
    public ArrayList<StringBuilder>[] cache = new ArrayList[100];

    public ArrayList<StringBuilder> generate(int n) {
        /* 如果缓存里面有，则直接返回 */
        if (cache[n] != null) {
            return cache[n];
        }
        ArrayList<StringBuilder> list = new ArrayList<>();

        /* 如果n为0，则只能返回空字符串 */
        if (n == 0) {
            list.add(new StringBuilder(""));
        } else {
            /* 遍历n-1长度的每一个位置 */
            for (int i = 0; i < n; i++) {
                for (StringBuilder left : generate(i)) {
                    for (StringBuilder right : generate(n - 1 - i)) {
                        /* 将左边用多出来的这个小括号包起来，右边不动直接拼接 */
                        list.add(new StringBuilder().append("(").append(left).append(")").append(right));
                    }
                }
            }
        }
        /* 记录缓存 */
        cache[n] = list;

        return list;
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        for (StringBuilder sb : generate(n)) {
            list.add(sb.toString());
        }
        return list;
    }
}
