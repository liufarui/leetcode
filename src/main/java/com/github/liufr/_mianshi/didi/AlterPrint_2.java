package com.github.liufr._mianshi.didi;

/**
 * @author lfr
 * @date 2020/8/20 14:57
 *
 * 解题思路：
 * 通过wait和notify操作，去实现线程的交替执行。
 */
public class AlterPrint_2 {
    private static final Object Lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new PrintThread(0));
        Thread thread2 = new Thread(new PrintThread(1));

        thread1.start();
        Thread.sleep(100);
        thread2.start();
    }

    static class PrintThread implements Runnable {
        private int X;

        PrintThread(int X) {
            this.X = X;
        }

        public void run() {
            while (true) {
                synchronized (Lock) {
                    System.out.println(X);
                    X = X + 2;
                    try {
                        Lock.notify();
                        Lock.wait();
                        System.out.println("PrintThread.run");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
