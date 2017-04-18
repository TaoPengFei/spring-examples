package cn.lee.jason.thread.concurrent.tools;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by jason on 17-4-18.
 */
public class CyclicBarrierTest2 {

    static CyclicBarrier cb = new CyclicBarrier(2, new A());

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    cb.wait();
                } catch (Exception e) {

                }
                System.out.println(1);
            }
        }).start();
        try {
            cb.wait();
        } catch (Exception e) {

        }
        System.out.println(2);
    }

    static class A implements Runnable {
        @Override
        public void run() {
            System.out.println(3);
        }
    }
}
