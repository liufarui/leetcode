package com.liufr.leetcode._codeleet;

import org.junit.Test;

/**
 * @Package: com.liufr.leetcode._codeleet
 * @ClassName: _476_findComplement
 * @Description:
 * @Author: liufarui
 * @CreateDate: 2021/4/27
 * @Copyright: Copyright (c)2021 JDL.CN All Right Reserved
 * @Since: JDK 1.8
 * @Version: V1.0
 * 476. 数字的补数
 * 给你一个 正 整数 num ，输出它的补数。补数是对该数的二进制表示取反。
 */
public class _476_findComplement {
    @Test
    public void test() {
        System.out.println(findComplement(5));
    }

    public int findComplement(int num) {
        int num0 = 1;
        while (num0 <= num) {
            num0 = num0 << 1;
        }
        num0 -= 1;

        return num0 ^ num;
    }
}
