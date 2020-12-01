package com.github.liufr._codeleet;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author lfr
 * @date 2020/11/9 21:15
 *
 * 406. 根据身高重建队列
 *
 * 假设有打乱顺序的一群人站成一个队列。
 * 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。
 * 编写一个算法来重建这个队列。
 * 注意：
 * 总人数少于1100人。
 *
 * 执行用时：7 ms, 在所有 Java 提交中击败了 99.60% 的用户
 * 内存消耗： 39.4 MB, 在所有 Java 提交中击败了 89.92% 的用户
 * 解题思路：
 * 算是一种动态规划类的问题
 * 从高个子开始排，因为对于高个子来讲，矮个子对其是无影响的；
 * 从最高的人开始排，然后每次取出一个人，如果他前面有n个比他高或者等高的人，就把他放到第（n+1）个位置
 * 由于存在同样身高的人，所以在利用身高排序之后，还需要按照前面的人数从小到大排序，所以手动修改了排序算法
 *
 */
public class _406_reconstructQueue {
    @Test
    public void test() {
        int[][] aa = reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}});
        System.out.println(Arrays.deepToString(aa));
    }

    int[][] ret;

    public int[][] reconstructQueue(int[][] people) {
        if (people.length == 0) {
            return people;
        }
        Arrays.sort(people, (o1, o2) -> 1000 * (o2[0] - o1[0]) + (o1[1] - o2[1]));
        ret = new int[people.length][people[0].length];

        for (int[] person : people) {
            insert(person);
        }
        return ret;
    }

    private void insert(int[] person) {
        int addr = person[1];
//        for (int i = ret.length - 1; i > addr; i--) {
//            ret[i] = ret[i - 1];
//        }
        if (ret.length - 1 - addr >= 0) System.arraycopy(ret, addr, ret, addr + 1, ret.length - 1 - addr);
        ret[addr] = person;
    }
}
