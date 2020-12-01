package com.github.liufr._codeleet;

import java.util.HashMap;

/**
 * @author lfr
 * @date 2020/7/28 17:22
 * 
 * 169. 多数元素
 * 
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 解题思路：
 * HashMap记录次数。
 */
public class _169_majorityElement {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int size = nums.length / 2;
        for (Integer num : nums) {
            int n = 1;
            if (map.containsKey(num)) {
                n = map.get(num);
                map.put(num, ++n);
            } else {
                map.put(num, 1);
            }
            if (n > size) {
                return num;
            }
        }
        return 0;
    }
}
