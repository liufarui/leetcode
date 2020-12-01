package com.github.liufr._codeleet;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author lfr
 * @date 2020/8/28 20:04
 *
 * 解题思路：
 * 2 ms   79.76%
 * 看图说话
 */
public class _300_lengthOfLIS_2 {
    @Test
    public void test() {
        System.out.println(lengthOfLIS(new int[]{4, 10, 4, 3, 8, 9}));
    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        List<Integer> list = new LinkedList<Integer>();
        list.add(nums[0]);

        for (int num : nums) {
            if (num > list.get(list.size() - 1)) {
                list.add(num);
                continue;
            }
            for (int i = 0; i < list.size(); i++) {
                if (num <= list.get(i)) {
                    list.set(i, num);
                    break;
                }
            }
        }
        return list.size();
    }
}
