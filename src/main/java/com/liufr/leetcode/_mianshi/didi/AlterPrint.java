package com.liufr.leetcode._mianshi.didi;

/**
 * @author lfr
 * @date 2020/8/20 13:40
 *
 * 解题思路：
 * 设置一个全局num值，一个lock锁。
 * 一个线程打印偶数，一个线程打印奇数；
 * 打印的时候判断是否已经打印，如果打印了，则释放锁，唤醒另外一个线程。
 */
public class AlterPrint {
    private static final Object lock = new Object();
    private static volatile int num = 0;

    public static void main(String[] args) {
        Thread thread1 = new Thread(new PrintThread1());
        Thread thread2 = new Thread(new PrintThread2());

        thread1.start();
        thread2.start();
    }

    static class PrintThread1 implements Runnable {
        public void run() {
            while (true) {
                synchronized (lock) {
                    if (num % 2 == 0) {
                        num++;
                        System.out.println(num);
                    }
                }
            }
        }
    }

    static class PrintThread2 implements Runnable {
        public void run() {
            while (true) {
                synchronized (lock) {
                    if (num % 2 == 1) {
                        num++;
                        System.out.println(num);
                    }
                }
            }
        }
    }
}
