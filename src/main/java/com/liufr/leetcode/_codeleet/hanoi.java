package com.liufr.leetcode._codeleet;

public class hanoi {
    public static void main(String[] args) {
        String start = "x";
        String temp = "y";
        String end = "z";
        hanoiMove(6, start, temp, end);
    }

    public static void hanoiMove(int n, String start, String temp, String end) {
        if (n < 1) {
            System.out.println("汉诺塔的层数不能小于1");
        } else if (n == 1) {
            System.out.println("移动: " + start + " -> " + end);
        } else {
            hanoiMove(n - 1, start, end, temp);
            System.out.println("移动: " + start + " -> " + end);
            hanoiMove(n - 1, temp, start, end);
        }
    }
}
