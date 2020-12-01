package com.github.liufr._codeleet;

import java.util.HashMap;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * @author lfr
 * @date 2020/9/1 17:24
 *
 * 347. 前 K 个高频元素
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 * 17 ms 67.68%
 * HashMap+优先队列
 */
public class _347_topKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        PriorityQueue<Frequent> pq = new PriorityQueue<>();
        for (Integer num : map.keySet()) {
            pq.offer(new Frequent(num, map.get(num)));
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; i++) {
            ret[i] = Objects.requireNonNull(pq.poll()).num;
        }
        return ret;
    }

    private static class Frequent implements Comparable<Frequent> {
        private final Integer num;
        private final Integer count;

        public Frequent(Integer num, Integer count) {
            this.num = num;
            this.count = count;
        }

        @Override
        public int compareTo(Frequent o) {
            return o.count - count;
        }
    }
}
