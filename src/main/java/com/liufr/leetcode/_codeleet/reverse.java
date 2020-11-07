package com.liufr.leetcode._codeleet;

public class reverse {
    public int reverse(int x) {
        long result = 0;

        while(x != 0) {
            int temp = x%10;
            x=x/10;
            result = result*10 + temp;
        }

        return (int) result == result ? (int) result : 0;
    }
}
